package com.ming.bns.admin.controller.bns;

import com.ming.bns.admin.service.bns.LuckService;
import com.ming.bns.admin.vo.bns.LuckVo;
import com.ming.bns.admin.entity.bns.Luck;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;

import java.util.Date;
import java.util.List;

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
