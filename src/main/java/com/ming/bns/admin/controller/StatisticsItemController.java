package com.ming.bns.admin.controller;

import com.ming.bns.admin.vo.StatisticsItemVo;
import com.ming.bns.admin.entity.StatisticsItem;
import com.ming.bns.admin.service.StatisticsItemService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 统计项
 * @author: Administrator
 * @date: 2020-08-12
 */
@RestController
@RequestMapping("/bns/statistics/item")
public class StatisticsItemController {

    @Autowired
    private StatisticsItemService statisticsItemService;

    @Log("StatisticsItem")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(StatisticsItemVo statisticsItemVo){
        Pagination<StatisticsItem> pagination = statisticsItemService.selectPage(statisticsItemVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("StatisticsItem")
    @GetMapping("/selectList")
    public ResultMsg selectList(StatisticsItemVo statisticsItemVo){
        return ResultMsg.success(statisticsItemService.selectList(statisticsItemVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("StatisticsItem")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(StatisticsItemVo statisticsItemVo){
        return ResultMsg.success(statisticsItemService.selectOne(statisticsItemVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Log("StatisticsItem")
    @PostMapping("/insert")
    public ResultMsg insert(StatisticsItem statisticsItem){
        if(statisticsItem == null){
            return ResultMsg.failed();
        }
        int i = statisticsItemService.insert(statisticsItem);
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
    @Log("StatisticsItem")
    @PostMapping("/update")
    public ResultMsg update(StatisticsItem statisticsItem){
        if(statisticsItem == null || statisticsItem.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = statisticsItemService.update(statisticsItem);
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
    @Log("StatisticsItem")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = statisticsItemService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
