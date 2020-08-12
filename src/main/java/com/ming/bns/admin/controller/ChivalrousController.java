package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.aspect.statistics.VisitStatistics;
import com.ming.bns.admin.vo.ChivalrousVo;
import com.ming.bns.admin.entity.Chivalrous;
import com.ming.bns.admin.service.ChivalrousService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.StarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 侠义团等级
 * @author: Administrator
 * @date: 2020-07-21
 */
@RestController
@RequestMapping("/chivalrous")
public class ChivalrousController {

    @Autowired
    private ChivalrousService chivalrousService;

    /**
     * 计算
     */
    @Log("Chivalrous")
    @VisitStatistics(type = "countChivalrous",desc = "计算侠义团")
    @PostMapping("/countChivalrous")
    public ResultMsg countChivalrous(ChivalrousVo chivalrousVo){
        Map<String,Object> data = chivalrousService.countExp(chivalrousVo);
        return ResultMsg.success(data);
    }

    @Log("Chivalrous")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(ChivalrousVo chivalrousVo){
        Pagination<Chivalrous> pagination = chivalrousService.selectPage(chivalrousVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Log("Chivalrous")
    @GetMapping("/selectList")
    public ResultMsg selectList(ChivalrousVo chivalrousVo){
        return ResultMsg.success(chivalrousService.selectList(chivalrousVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Log("Chivalrous")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(ChivalrousVo chivalrousVo){
        return ResultMsg.success(chivalrousService.selectOne(chivalrousVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Log("Chivalrous")
    @PostMapping("/insert")
    public ResultMsg insert(Chivalrous chivalrous){
        if(chivalrous == null){
            return ResultMsg.failed();
        }
        int i = chivalrousService.insert(chivalrous);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Log("Chivalrous")
    @PostMapping("/update")
    public ResultMsg update(Chivalrous chivalrous){
        if(chivalrous == null || chivalrous.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = chivalrousService.update(chivalrous);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @Log("Chivalrous")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = chivalrousService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
