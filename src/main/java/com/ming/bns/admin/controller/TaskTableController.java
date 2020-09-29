package com.ming.bns.admin.controller;

import com.ming.bns.admin.entity.TaskChallenge;
import com.ming.bns.admin.service.TaskTableService;
import com.ming.bns.admin.utils.Tools;
import com.ming.bns.admin.vo.TaskTableVo;
import com.ming.bns.admin.entity.TaskTable;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 任务表
 * @author: Administrator
 * @date: 2020-08-22
 */
@RestController
@RequestMapping("/bns/task/table")
public class TaskTableController {

    @Autowired
    private TaskTableService taskTableService;

    @Log("TaskTable")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(TaskTableVo taskTableVo){
        Pagination<TaskTable> pagination = taskTableService.selectPage(taskTableVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskTable")
    @GetMapping("/selectList")
    public ResultMsg selectList(TaskTableVo taskTableVo){
        return ResultMsg.success(taskTableService.selectList(taskTableVo));
    }

    @Log("TaskTable")
    @GetMapping("/selectListByWeek")
    public ResultMsg selectListByWeek(TaskTableVo taskTableVo){
        String week = Tools.getWeek();
        taskTableVo.setWeekName(week);
        List<TaskTable> list = taskTableService.selectList(taskTableVo);
        for (TaskTable taskTable : list){
            taskTable.getTaskChallenge().setColor("danger");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data_1",getGroupList(week,1,list));
        map.put("data_2",getGroupList(week,2,list));
        map.put("data_3",getGroupList(week,3,list));
        map.put("data_4",getGroupList(week,4,list));
        return ResultMsg.success(map);
    }

    @GetMapping("/selectGroupList")
    public ResultMsg selectGroupList(TaskTableVo taskTableVo){
        List<TaskTable> list = taskTableService.selectList(taskTableVo);
        Map<String,Object> map = new HashMap<>();
        map.put("data1_1",getGroupList("1",1,list));
        map.put("data1_2",getGroupList("1",2,list));
        map.put("data1_3",getGroupList("1",3,list));
        map.put("data1_4",getGroupList("1",4,list));

        map.put("data2_1",getGroupList("2",1,list));
        map.put("data2_2",getGroupList("2",2,list));
        map.put("data2_3",getGroupList("2",3,list));
        map.put("data2_4",getGroupList("2",4,list));

        map.put("data3_1",getGroupList("3",1,list));
        map.put("data3_2",getGroupList("3",2,list));
        map.put("data3_3",getGroupList("3",3,list));
        map.put("data3_4",getGroupList("3",4,list));

        map.put("data4_1",getGroupList("4",1,list));
        map.put("data4_2",getGroupList("4",2,list));
        map.put("data4_3",getGroupList("4",3,list));
        map.put("data4_4",getGroupList("4",4,list));

        map.put("data5_1",getGroupList("5",1,list));
        map.put("data5_2",getGroupList("5",2,list));
        map.put("data5_3",getGroupList("5",3,list));
        map.put("data5_4",getGroupList("5",4,list));

        map.put("data6_1",getGroupList("6",1,list));
        map.put("data6_2",getGroupList("6",2,list));
        map.put("data6_3",getGroupList("6",3,list));
        map.put("data6_4",getGroupList("6",4,list));

        map.put("data7_1",getGroupList("7",1,list));
        map.put("data7_2",getGroupList("7",2,list));
        map.put("data7_3",getGroupList("7",3,list));
        map.put("data7_4",getGroupList("7",4,list));
        return ResultMsg.success(map);
    }

    private List<TaskChallenge> getGroupList(String week,Integer type,List<TaskTable> list){
        List<TaskTable> tableList = list.stream().filter(t->week.equals(t.getWeekName()) && type.equals(t.getType())).collect(Collectors.toList());
        List<TaskChallenge> challengeList = new ArrayList<>();
        for (TaskTable table : tableList){
            TaskChallenge challenge = table.getTaskChallenge();
            challengeList.add(challenge);
        }
        return challengeList;
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskTable")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(TaskTableVo taskTableVo){
        return ResultMsg.success(taskTableService.selectOne(taskTableVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskTable")
    @PostMapping("/insert")
    public ResultMsg insert(TaskTable taskTable){
        if(taskTable == null){
            return ResultMsg.failed();
        }
        int i = taskTableService.insert(taskTable);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

    @PostMapping("/insertList")
    public ResultMsg insertList(TaskTable taskTable){
        if(taskTable == null || StringUtils.isBlank(taskTable.getWeekName()) || taskTable.getType() == null){
            return ResultMsg.failed();
        }
        TaskTableVo taskTableVo = new TaskTableVo();
        taskTableVo.setWeekName(taskTable.getWeekName());
        taskTableVo.setType(taskTable.getType());
        taskTableService.delete(taskTableVo);
        List<Map<String,Object>> mapList = taskTable.getTaskChallengeMapList();
        for(Map<String,Object> map : mapList){
            TaskTable task = new TaskTable();
            task.setWeekName(taskTable.getWeekName());
            task.setType(taskTable.getType());
            task.setTaskChallengeId(Long.valueOf((String)map.get("id")));
            taskTableService.insert(task);
        }
        return ResultMsg.success();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskTable")
    @PostMapping("/update")
    public ResultMsg update(TaskTable taskTable){
        if(taskTable == null || taskTable.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = taskTableService.update(taskTable);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskTable")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = taskTableService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
