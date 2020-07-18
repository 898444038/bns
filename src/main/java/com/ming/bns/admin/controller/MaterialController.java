package com.ming.bns.admin.controller;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.MaterialVo;
import com.ming.bns.admin.service.MaterialService;
import com.ming.bns.admin.entity.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 材料
 * @author: Administrator
 * @date: 2020-07-16
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

	/**
	 * 查询分页列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@GetMapping("/selectPage")
	public ResultMsg selectPage(MaterialVo materialVo){
		Pagination<Material> materialList = materialService.selectPage(materialVo);
		return ResultMsg.success(materialList);
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @GetMapping("/selectList")
    public ResultMsg selectList(MaterialVo materialVo){
		materialVo.setDelFlag(false);
        return ResultMsg.success(materialService.selectList(materialVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @GetMapping("/selectOne")
    public ResultMsg selectOne(MaterialVo materialVo){
        return ResultMsg.success(materialService.selectOne(materialVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @PostMapping("/insert")
    public ResultMsg insert(Material material){
    	if(material == null){
    		return ResultMsg.failed();
		}
		material.setCreateTime(new Date());
    	material.setDelFlag(false);
		int i = materialService.insert(material);
    	if(i>0){
			return ResultMsg.success();
		}
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @PostMapping("/update")
    public ResultMsg update(Material material){
    	if(material == null || material.getId() == null){
			return ResultMsg.failed("ID不能为空！");
		}
        int i = materialService.update(material);
		if(i>0){
			return ResultMsg.success();
		}
		return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
		if(id == null){
			return ResultMsg.failed("ID不能为空！");
		}
		MaterialVo materialVo = new MaterialVo();
		materialVo.setId(id);
		materialVo.setDelFlag(true);
        int i = materialService.update(materialVo);
		if(i>0){
			return ResultMsg.success();
		}
		return ResultMsg.failed();
    }
}
