package com.ming.bns.admin.controller;

import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.MaterialVo;
import com.ming.bns.admin.service.MaterialService;
import com.ming.bns.admin.entity.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
	public List<Material> selectPage(MaterialVo materialVo){
		return materialService.selectPage(materialVo);
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @GetMapping("/selectList")
    public List<Material> selectList(MaterialVo materialVo){
        return materialService.selectList(materialVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @GetMapping("/selectOne")
    public Material selectOne(MaterialVo materialVo){
        return materialService.selectOne(materialVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody Material material){
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
    public ResultMsg update(@RequestBody Material material){
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
    @PostMapping("/delete")
    public ResultMsg delete(Long id){
		if(id == null){
			return ResultMsg.failed("ID不能为空！");
		}
        int i = materialService.delete(id);
		if(i>0){
			return ResultMsg.success();
		}
		return ResultMsg.failed();
    }
}
