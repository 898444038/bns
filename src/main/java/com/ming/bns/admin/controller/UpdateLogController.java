package com.ming.bns.admin.controller;

import com.ming.bns.admin.vo.UpdateLogVo;
import com.ming.bns.admin.service.UpdateLogService;
import com.ming.bns.admin.entity.UpdateLog;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 更新日志
 * @author: Administrator
 * @date: 2020-08-26
 */
@RestController
@RequestMapping("/update/log")
public class UpdateLogController {

    @Autowired
    private UpdateLogService updateLogService;

    @Log("UpdateLog")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(UpdateLogVo updateLogVo){
        Pagination<UpdateLog> pagination = updateLogService.selectPage(updateLogVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Log("UpdateLog")
    @GetMapping("/selectList")
    public ResultMsg selectList(UpdateLogVo updateLogVo){
        return ResultMsg.success(updateLogService.selectList(updateLogVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Log("UpdateLog")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(UpdateLogVo updateLogVo){
        return ResultMsg.success(updateLogService.selectOne(updateLogVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Log("UpdateLog")
    @PostMapping("/insert")
    public ResultMsg insert(UpdateLog updateLog){
        if(updateLog == null){
            return ResultMsg.failed();
        }
        int i = updateLogService.insert(updateLog);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Log("UpdateLog")
    @PostMapping("/update")
    public ResultMsg update(UpdateLog updateLog){
        if(updateLog == null || updateLog.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = updateLogService.update(updateLog);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Log("UpdateLog")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = updateLogService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
