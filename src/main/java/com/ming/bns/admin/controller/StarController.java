package com.ming.bns.admin.controller;

import com.ming.bns.admin.entity.Star;
import com.ming.bns.admin.vo.StarVo;
import com.ming.bns.admin.service.StarService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-18
 */
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    private StarService starService;

	@GetMapping("/selectPage")
    public ResultMsg selectPage(StarVo starVo){
        Pagination<Star> pagination = starService.selectPage(starVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-18
	 */
    @GetMapping("/selectList")
    public ResultMsg selectList(StarVo starVo){
        return ResultMsg.success(starService.selectList(starVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-18
	 */
    @GetMapping("/selectOne")
    public ResultMsg selectOne(StarVo starVo){
        return ResultMsg.success(starService.selectOne(starVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-18
	 */
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody Star star){
        if(star == null){
            return ResultMsg.failed();
        }
        int i = starService.insert(star);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-18
	 */
    @PostMapping("/update")
    public ResultMsg update(@RequestBody Star star){
        if(star == null || star.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = starService.update(star);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-18
	 */
    @PostMapping("/delete")
    public ResultMsg delete(Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = starService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
