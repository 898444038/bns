package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.service.SystemLogService;
import com.ming.bns.admin.vo.SystemLogVo;
import com.ming.bns.admin.entity.SystemLog;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日志
 * @author: Administrator
 * @date: 2020-08-12
 */
@RestController
@RequestMapping("/bns/system/log")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;

    @Log("SystemLog")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(SystemLogVo systemLogVo){
        Pagination<SystemLog> pagination = systemLogService.selectPage(systemLogVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("SystemLog")
    @GetMapping("/selectList")
    public ResultMsg selectList(SystemLogVo systemLogVo){
        return ResultMsg.success(systemLogService.selectList(systemLogVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("SystemLog")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(SystemLogVo systemLogVo){
        return ResultMsg.success(systemLogService.selectOne(systemLogVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("SystemLog")
    @PostMapping("/insert")
    public ResultMsg insert(SystemLog systemLog){
        if(systemLog == null){
            return ResultMsg.failed();
        }
        int i = systemLogService.insert(systemLog);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("SystemLog")
    @PostMapping("/update")
    public ResultMsg update(SystemLog systemLog){
        if(systemLog == null || systemLog.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = systemLogService.update(systemLog);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("SystemLog")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = systemLogService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
