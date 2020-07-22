package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.mapper.ChivalrousMapper;
import com.ming.bns.admin.entity.Chivalrous;
import com.ming.bns.admin.vo.ChivalrousVo;
import com.ming.bns.admin.service.ChivalrousService;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 侠义团等级
 * @author: Administrator
 * @date: 2020-07-21
 */
@Service
public class ChivalrousServiceImpl implements ChivalrousService {

    @Resource
    private ChivalrousMapper chivalrousMapper;

	@Override
	public Pagination<Chivalrous> selectPage(ChivalrousVo chivalrousVo) {
        Pagination<Chivalrous> pagination = new Pagination<>();
        int count = chivalrousMapper.selectCount(chivalrousVo);
        List<Chivalrous> list = chivalrousMapper.selectPage(chivalrousVo);
        pagination.setPageNo(chivalrousVo.getPageNo());
        pagination.setPageSize(chivalrousVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Override
    public List<Chivalrous> selectList(ChivalrousVo chivalrousVo) {
        return chivalrousMapper.selectList(chivalrousVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Override
    public Chivalrous selectOne(ChivalrousVo chivalrousVo) {
        return chivalrousMapper.selectOne(chivalrousVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Override
    public int insert(Chivalrous chivalrous) {
        return chivalrousMapper.insert(chivalrous);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Override
    public int update(Chivalrous chivalrous) {
        return chivalrousMapper.update(chivalrous);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Override
    public int delete(Long id) {
        return chivalrousMapper.delete(id);
    }

    @Override
    public Map<String, Object> countExp(ChivalrousVo chivalrousVo) {
        List<Chivalrous> list = chivalrousMapper.selectList(chivalrousVo);
        Map<String, Object> data = new HashMap<>();
        Map<Integer,Long> map = list.stream().collect(Collectors.toMap(Chivalrous::getChivalrous,Chivalrous::getExp));
        Long startExp = null;
        if(chivalrousVo.getCurrExp() != null){
            startExp = chivalrousVo.getCurrExp()*10000L;
        }
        String[] dayExps = null;
        if(chivalrousVo.getDayExp().contains(",")){
            dayExps = chivalrousVo.getDayExp().split(",");
        }else if(chivalrousVo.getDayExp().contains("，")){
            dayExps = chivalrousVo.getDayExp().split("，");
        }


        List<Map<String,Object>> groupList = group(chivalrousVo.getStart(),chivalrousVo.getEnd(),map);
        if(startExp!=null){
            groupList.get(0).put("startExp",startExp);
        }

        for (String dayExp : dayExps){
            List<Map<String,Object>> mapList = count(groupList,chivalrousVo.getStart(),Long.valueOf(dayExp)*10000L);
            data.put(dayExp,mapList);
        }

        List<Map<String,Object>> dataMap = new ArrayList<>();
        Set<String> xAxisSet = new LinkedHashSet<>();
        for (Map.Entry<String,Object> entry : data.entrySet()){
            List<Map<String,Object>> list1 = (List<Map<String,Object>>)entry.getValue();
            Map<String,Object> map0 = new HashMap<>();
            map0.put("name","每日"+entry.getKey()+"万经验,升级所需天数");
            List<Integer> list2 = new ArrayList<>();
            for (Map<String,Object> entrys : list1){
                xAxisSet.add(((Long)entrys.get("level")+1L)+"级");
                list2.add((Integer) entrys.get("day"));
            }
            map0.put("data",list2.toArray());
            dataMap.add(map0);
        }

        Map<String,Object> result = new HashMap<>();
        result.put("xAxis",xAxisSet.toArray());
        result.put("list",dataMap);
        return result;
    }

    private List<Map<String,Object>> count(List<Map<String,Object>> groupList,Long level,Long dayExp){
        groupList.get(0).put("endExp",(Long)groupList.get(0).get("endExp")-(Long)groupList.get(0).get("startExp"));
        groupList.get(0).put("startExp",0L);
        long total = 0;
        List<Long> line = new ArrayList<>();
        for (Map<String,Object> group : groupList){
            long exp = (Long)group.get("endExp");
            line.add(exp+total);
            total += exp;
        }
        long expTotal = 0;
        int day = 1;
        long lv = level;
        //List<Map<String,Object>> mapList = new ArrayList<>();
        List<Map<String,Object>> mapLists = new ArrayList<>();
        for (Long exp : line){
            while (expTotal < exp){
                //Map<String,Object> map = new HashMap<>();
                if(exp-expTotal < dayExp){
                    Map<String,Object> maps = new HashMap<>();
                    maps.put("day",day-1);
                    maps.put("level",lv);
                    maps.put("cuurExp",expTotal+dayExp);
                    mapLists.add(maps);
                    lv++;
                }
                //map.put("day",day);
                //map.put("level",lv);
                //map.put("cuurExp",expTotal+dayExp);
                day++;
                expTotal += dayExp;
                //mapList.add(map);
            }
        }
        mapLists.stream().forEach(System.out::println);
        return mapLists;
    }



    /**
     * 计算等级分组
     * @param startLevel
     * @param endLevel
     */
    private List<Map<String,Object>> group(Long startLevel,Long endLevel,Map<Integer,Long> map){
        Map<Integer,Long> maps = map.entrySet().stream().filter(m -> m.getKey() >= startLevel && m.getKey() < endLevel)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal,newVal)->oldVal,
                        LinkedHashMap::new
                ));
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (Map.Entry<Integer,Long> entry : maps.entrySet()){
            Map<String,Object> objectMap = new HashMap<>();
            objectMap.put("level",entry.getKey().longValue());
            objectMap.put("startExp",0L);
            objectMap.put("endExp",entry.getValue());
            mapList.add(objectMap);
        }
        return mapList;
    }
}
