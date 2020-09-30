package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.entity.bns.Star;
import com.ming.bns.admin.mapper.bns.StarMapper;
import com.ming.bns.admin.vo.bns.StarVo;
import com.ming.bns.admin.service.bns.StarService;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-19
 */
@Service
public class StarServiceImpl implements StarService {

    @Resource
    private StarMapper starMapper;

	@Override
	public Pagination<Star> selectPage(StarVo starVo) {
        Pagination<Star> pagination = new Pagination<>();
        int count = starMapper.selectCount(starVo);
        List<Star> list = starMapper.selectPage(starVo);
        pagination.setPageNo(starVo.getPageNo());
        pagination.setPageSize(starVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    @Override
    public List<Star> selectList(StarVo starVo) {
        return starMapper.selectList(starVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    @Override
    public Star selectOne(StarVo starVo) {
        return starMapper.selectOne(starVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    @Override
    public int insert(Star star) {
        return starMapper.insert(star);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    @Override
    public int update(Star star) {
        return starMapper.update(star);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    @Override
    public int delete(Long id) {
        return starMapper.delete(id);
    }

    @Override
    public Map<String, Object> countStarExp(StarVo starVo) {
        List<Star> list = starMapper.selectList(starVo);
        Map<String, Object> data = new HashMap<>();
        Map<Integer,Long> map = list.stream().collect(Collectors.toMap(Star::getStar,Star::getExp));
        Long startExp = null;
        if(starVo.getCurrExp() != null){
            startExp = starVo.getCurrExp()*10000L;
        }
        //Long endExp = map.get(starVo.getStart());
        String[] dayExps = null;
        if(starVo.getDayExp().contains(",")){
            dayExps = starVo.getDayExp().split(",");
        }else if(starVo.getDayExp().contains("，")){
            dayExps = starVo.getDayExp().split("，");
        }else{
            dayExps = starVo.getDayExp().split(",");
        }

        List<Map<String,Object>> groupList = group(starVo.getStart(),starVo.getEnd(),map);
        if(startExp!=null){
            groupList.get(0).put("startExp",startExp);
        }

//        for (Map<String,Object> group : groupList){
//            count((Long) group.get("level"),(Long) group.get("startExp"),(Long) group.get("endExp"),Long.valueOf(dayExps[0])*10000);
//        }
        //counts(groupList,starVo.getStart(),Long.valueOf(dayExps[0])*10000);

        for (String dayExp : dayExps){
            List<Map<String,Object>> mapList = count(groupList,starVo.getStart(),Long.valueOf(dayExp)*10000L);
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
        result.put("rank",list.stream().filter(s -> s.getStar()>=starVo.getStart() && s.getStar()<starVo.getEnd()).collect(Collectors.toList()));
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

//    private void count(Long level,Long startExp,Long endExp,Long dayExp){
//        System.out.println("当前等级："+level+",经验"+(endExp-startExp)+",需"+(endExp-startExp)/dayExp+"天");
//
//    }

    private void counts(List<Map<String,Object>> groupList,Long level,Long dayExp){
        int day = 1;
        long lv = level;
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (Map<String,Object> group : groupList){
            Long startExp = (Long)group.get("startExp");
            Long endExp = (Long)group.get("endExp");
            while (startExp < endExp){
                Map<String,Object> map = new HashMap<>();
                map.put("day",day);
                map.put("level",lv);
                map.put("cuurExp",startExp+dayExp);
                day++;
                startExp += dayExp;
                mapList.add(map);
            }
            lv++;
            if(startExp>endExp){
                Map<String,Object> map = new HashMap<>();
                map.put("day",day);
                map.put("level",lv);
                map.put("cuurExp",startExp+dayExp);
            }
        }
        System.out.println();
    }
}
