package com.ming.bns.admin.controller.bns;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ming.bns.admin.entity.bns.LuckItem;
import com.ming.bns.admin.service.bns.LuckService;
import com.ming.bns.admin.utils.luck.LuckUtils;
import com.ming.bns.admin.utils.luck.luck1.Award;
import com.ming.bns.admin.utils.luck.luck1.AwardGroup;
import com.ming.bns.admin.utils.luck.luck1.AwardStatistics;
import com.ming.bns.admin.vo.bns.LuckVo;
import com.ming.bns.admin.entity.bns.Luck;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;

import java.lang.reflect.Type;
import java.util.*;

/**
 * 抽奖表
 * @author: Administrator
 * @date: 2020-10-23
 */
@RestController
@RequestMapping("/bns/luck")
public class LuckController {

    @Autowired
    private LuckService luckService;

    /**
     * 抽奖计算
     * @author: Administrator
     * @date: 2020-10-23
     */
    @Log("bns.calculate")
    @PostMapping("/calculate")
    public ResultMsg calculate(LuckVo luckVo){
        if(luckVo.getId() == null){
            return ResultMsg.failed("请选择抽奖模板！");
        }
        AwardGroup awardGroup = new AwardGroup();
        awardGroup.setAutoReduce(false); // 是否每抽一次减少一个奖品
        Luck luck = luckService.selectOne(luckVo);
        Type type = new TypeToken<List<LuckItem>>(){}.getType();
        List<LuckItem> list = new Gson().fromJson(luck.getItems(),type);
        for (LuckItem item : list){
            awardGroup.addAward(new Award(item.getName(), item.getWeight(), 0));
        }
        System.out.println("总权重："+awardGroup.getTotal());

        Award award = null;
        int loop = luckVo.getLoop();
        int count = luckVo.getCount();
        AwardStatistics statistics = new AwardStatistics();
        for (int i = 0; i < loop; i++) {
            int group = i+1;
            statistics.initAward(group,awardGroup.getAwardgroup());
            for (int j = 0; j < count; j++) {
                award = awardGroup.startGetAward();
                String record = LuckUtils.addZeroForNumber((j+1)+"",3)+"、"+award;
                //System.out.println(record);
                award.setIndex((j+1)+"");
                statistics.addAward(group,award);
                statistics.addAwardRecord(group,record);
            }
        }
        //statistics.statisticsHtml();
        //System.out.println(statistics);
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (Map.Entry<Integer,Map<String,List<Award>>> mapEntry : statistics.awardMap.entrySet()){
            List<Map<String,Object>> dataList = new ArrayList<>();
            Map<String,List<Award>> values = mapEntry.getValue();
            for (Map.Entry<String,List<Award>> entry : values.entrySet()){
                Integer weight = null;
                for (Award a : statistics.awardList){
                    if(entry.getKey().equals(a.getName())){
                        weight = a.getWeight();
                    }
                }

                List<Award> awards = entry.getValue();
                StringBuffer sb = new StringBuffer("");
                for (Award a : awards){
                    sb.append(a.getIndex()+",");
                }
                Map<String,Object> map = new LinkedHashMap<>();
                map.put("name",entry.getKey());
                map.put("weight",weight);
                map.put("count",entry.getValue().size());
                map.put("index",sb.toString());
                dataList.add(map);
            }

            Map<String,Object> map = new LinkedHashMap<>();
            map.put("loop",mapEntry.getKey());
            map.put("list",dataList);
            map.put("record",statistics.recordMap.get(mapEntry.getKey()));
            mapList.add(map);
        }
        return ResultMsg.success(mapList);
    }

    @Log("bns.Luck")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(LuckVo luckVo){
        Pagination<Luck> pagination = luckService.selectPage(luckVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.Luck")
    @GetMapping("/selectList")
    public ResultMsg selectList(LuckVo luckVo){
        return ResultMsg.success(luckService.selectList(luckVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.Luck")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(LuckVo luckVo){
        return ResultMsg.success(luckService.selectOne(luckVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.Luck")
    @PostMapping("/insert")
    public ResultMsg insert(Luck luck){
        if(StringUtils.isBlank(luck.getName())){
            return ResultMsg.failed();
        }
        luck.setCreateTime(new Date());
        int i = luckService.insert(luck);
        if(i>0){
            return ResultMsg.success(luck.getId());
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.Luck")
    @PostMapping("/update")
    public ResultMsg update(Luck luck){
        if(luck == null || luck.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = luckService.update(luck);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.Luck")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = luckService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
