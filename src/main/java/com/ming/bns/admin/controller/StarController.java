package com.ming.bns.admin.controller;

import com.ming.bns.admin.entity.Star;
import com.ming.bns.admin.vo.StarVo;
import com.ming.bns.admin.service.StarService;

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
 * 星级
 * @author: Administrator
 * @date: 2020-07-15
 */
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    private StarService starService;

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @GetMapping("/selectList")
    public List<Star> selectList(StarVo starVo){
        return starService.selectList(starVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @GetMapping("/selectOne")
    public Star selectOne(StarVo starVo){
        return starService.selectOne(starVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @PostMapping("/insert")
    public int insert(@RequestBody Star star){
        return starService.insert(star);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @PutMapping("/update")
    public int update(@RequestBody Star star){
        return starService.update(star);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @DeleteMapping("/delete")
    public int delete(Long id){
        return starService.delete(id);
    }
}
