package com.ming.bns.admin.controller;

import com.ming.bns.admin.vo.StatisticsVo;
import com.ming.bns.admin.service.StatisticsService;
import com.ming.bns.admin.entity.Statistics;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 统计
 * @author: Administrator
 * @date: 2020-08-12
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Log("Statistics")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(StatisticsVo statisticsVo){
        Pagination<Statistics> pagination = statisticsService.selectPage(statisticsVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("Statistics")
    @GetMapping("/selectList")
    public ResultMsg selectList(StatisticsVo statisticsVo){
        return ResultMsg.success(statisticsService.selectList(statisticsVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("Statistics")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(StatisticsVo statisticsVo){
        return ResultMsg.success(statisticsService.selectOne(statisticsVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("Statistics")
    @PostMapping("/insert")
    public ResultMsg insert(Statistics statistics){
        if(statistics == null){
            return ResultMsg.failed();
        }
        int i = statisticsService.insert(statistics);
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
    @Log("Statistics")
    @PostMapping("/update")
    public ResultMsg update(Statistics statistics){
        if(statistics == null || statistics.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = statisticsService.update(statistics);
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
    @Log("Statistics")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = statisticsService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
