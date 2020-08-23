package com.ming.bns.admin.controller;

import com.ming.bns.admin.service.TaskChallengeService;
import com.ming.bns.admin.vo.TaskChallengeVo;
import com.ming.bns.admin.entity.TaskChallenge;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 任务挑战
 * @author: Administrator
 * @date: 2020-08-22
 */
@RestController
@RequestMapping("/task/challenge")
public class TaskChallengeController {

    @Autowired
    private TaskChallengeService taskChallengeService;

    @Log("TaskChallenge")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(TaskChallengeVo taskChallengeVo){
        Pagination<TaskChallenge> pagination = taskChallengeService.selectPage(taskChallengeVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskChallenge")
    @GetMapping("/selectList")
    public ResultMsg selectList(TaskChallengeVo taskChallengeVo){
        return ResultMsg.success(taskChallengeService.selectList(taskChallengeVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskChallenge")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(TaskChallengeVo taskChallengeVo){
        return ResultMsg.success(taskChallengeService.selectOne(taskChallengeVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskChallenge")
    @PostMapping("/insert")
    public ResultMsg insert(TaskChallenge taskChallenge){
        if(taskChallenge == null){
            return ResultMsg.failed();
        }
        int i = taskChallengeService.insert(taskChallenge);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Log("TaskChallenge")
    @PostMapping("/update")
    public ResultMsg update(TaskChallenge taskChallenge){
        if(taskChallenge == null || taskChallenge.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = taskChallengeService.update(taskChallenge);
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
    @Log("TaskChallenge")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = taskChallengeService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
