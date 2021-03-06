package com.ming.bns.admin.utils.count;

import com.ming.bns.admin.entity.bns.TaskChallenge;
import com.ming.bns.admin.entity.bns.TaskTable;
import com.ming.bns.admin.utils.ListUtils;
import com.ming.bns.admin.vo.bns.TaskChallengeVo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChallengeUtil {
    public static List<TaskChallenge> copy(String ids1, List<TaskChallenge> list,Integer type) {
        List<TaskChallenge> data = new ArrayList<>();
        if(StringUtils.isNotBlank(ids1)){
            String[] ids = ids1.split(",");
            for (String id : ids){
                for (TaskChallenge taskChallenge : list){
                    if(id.equalsIgnoreCase(taskChallenge.getId().toString())){
                        TaskChallenge challenge = new TaskChallenge();
                        challenge.setId(taskChallenge.getId());
                        challenge.setName(taskChallenge.getName());
                        challenge.setChivalrous1(taskChallenge.getChivalrous1());
                        challenge.setChivalrous2(taskChallenge.getChivalrous2());
                        challenge.setChivalrous3(taskChallenge.getChivalrous3());
                        challenge.setType(type);
                        challenge.setFlag(type);
                        challenge.setSort(taskChallenge.getSort());
                        challenge.setReset(taskChallenge.getReset());
                        data.add(challenge);
                        break;
                    }
                }
            }
        }
        return data;
    }

    public static List<TaskChallenge> sort(List<TaskChallenge> all,List<TaskChallenge> data1){
        for(TaskChallenge challengeAll : all){
            for (TaskChallenge challenge : data1){
                if(challengeAll.getId().equals(challenge.getId())){
                    challengeAll.setFlag(challenge.getFlag());
                }
            }
        }
        //排序(多条件排序的时候，需要最后排序的字段需要放在前面排)
        all = all.stream()
                .sorted((c1,c2)->Long.compare(c1.getSort(),c2.getSort()))
                .sorted((c1,c2)->Integer.compare(c1.getFlag(),c2.getFlag()))//先根据flag排序
                .collect(Collectors.toList());
        return all;
    }

    public static List<Map<String,Object>> handle(TaskChallengeVo vo, List<TaskChallenge> list,List<TaskTable> tableList) {
        //分组&复制对象
        List<TaskChallenge> data1 = copy(vo.getIds1(),list,1);
        List<TaskChallenge> data2 = copy(vo.getIds2(),list,2);
        List<TaskChallenge> data3 = copy(vo.getIds3(),list,3);
        List<TaskChallenge> data4 = copy(vo.getIds4(),list,4);

        //排序
        List<TaskChallenge> all = new ArrayList<>();
        all.addAll(data1);
        all.addAll(data2);
        all.addAll(data3);
        all.addAll(data4);
        all = sort(all,data1);

        List<TaskChallenge> all1 = all.stream().filter(c->c.getReset().equals(0)).collect(Collectors.toList());
        List<TaskChallenge> all2 = all.stream().filter(c->!c.getReset().equals(0)).collect(Collectors.toList());

        //分成N组
        List<Integer> intList = new ArrayList<>();
        int num[] = new int[all2.size()];
        for(int i=0;i<all2.size();i++){
            num[i] = i;
            intList.add(0);
        }

        int type = 1;//0,1,2
        List<List<Integer>> resultList = ListUtils.averageAssign(intList,vo.getCount(),type);

        List<List<TaskChallenge>> result = new ArrayList<>();
        int x=0;int y=0;
        for(int i=0;i<resultList.size();i++){
            y += resultList.get(i).size();
            x = y - resultList.get(i).size();
            System.out.println(x+":"+y);
            List<TaskChallenge> subList = new ArrayList<>();
            subList.addAll(all1);
            subList.addAll(all2.subList(x,y));
            result.add(subList);
        }
        //List<List<TaskChallenge>> sprateList = ListUtils.partition(all,vo.getCount());
        //sprateList.stream().forEach(System.out::println);
        System.out.println();

//        StackUtil.clear();
//        StackUtil.split(num, vo.getCount(), 0, 0); // 从这个数组4个数中选择三个
//        List<List<Integer>> lists = StackUtil.lists;
//        System.out.println(lists);
        List<Map<String,Object>> mapList = new ArrayList<>();

        for (List<TaskChallenge> challenges : result){
            Map<String,Object> map = new HashMap<>();
            map.put("data1",getGroupList(1,challenges,tableList));
            map.put("data2",getGroupList(2,challenges,tableList));
            map.put("data3",getGroupList(3,challenges,tableList));
            map.put("data4",getGroupList(4,challenges,tableList));
            mapList.add(map);
        }
        return mapList;
    }


    private static List<TaskChallenge> getGroupList(Integer type,List<TaskChallenge> list,List<TaskTable> tableList){
        List<TaskChallenge> challengeList = list.stream().filter(t -> type.equals(t.getType())).collect(Collectors.toList());
        List<TaskTable> taskTableList = tableList.stream().filter(taskTable -> taskTable.getType().equals(type)).collect(Collectors.toList());
        for(TaskChallenge challenge : challengeList){
            for(TaskTable table : taskTableList){
                if(challenge.getId().equals(table.getTaskChallengeId())){
                    challenge.setColor("danger");//标识今日的挑战
                    break;
                }
            }
        }
        return challengeList;
    }
}
