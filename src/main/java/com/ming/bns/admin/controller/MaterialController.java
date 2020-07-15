package com.ming.bns.admin.controller;

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
    public int insert(@RequestBody Material material){
        return materialService.insert(material);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @PutMapping("/update")
    public int update(@RequestBody Material material){
        return materialService.update(material);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @DeleteMapping("/delete")
    public int delete(Long id){
        return materialService.delete(id);
    }
}
