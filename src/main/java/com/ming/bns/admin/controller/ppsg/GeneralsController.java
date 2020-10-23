package com.ming.bns.admin.controller.ppsg;

import com.ming.bns.admin.service.ppsg.GeneralsService;
import com.ming.bns.admin.vo.ppsg.GeneralsVo;
import com.ming.bns.admin.entity.ppsg.Generals;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 武将表
 * @author: Administrator
 * @date: 2020-10-23
 */
@RestController
@RequestMapping("/ppsg/generals")
public class GeneralsController {

    @Autowired
    private GeneralsService generalsService;

    @Log("ppsg.Generals")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralsVo generalsVo){
        Pagination<Generals> pagination = generalsService.selectPage(generalsVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("ppsg.Generals")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralsVo generalsVo){
        return ResultMsg.success(generalsService.selectList(generalsVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("ppsg.Generals")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralsVo generalsVo){
        return ResultMsg.success(generalsService.selectOne(generalsVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("ppsg.Generals")
    @PostMapping("/insert")
    public ResultMsg insert(Generals generals){
        if(generals == null){
            return ResultMsg.failed();
        }
        int i = generalsService.insert(generals);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("ppsg.Generals")
    @PostMapping("/update")
    public ResultMsg update(Generals generals){
        if(generals == null || generals.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalsService.update(generals);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("ppsg.Generals")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalsService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
