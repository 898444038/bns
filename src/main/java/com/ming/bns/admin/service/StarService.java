package com.ming.bns.admin.service;

import com.ming.bns.admin.entity.Star;
import com.ming.bns.admin.vo.StarVo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-15
 */
public interface StarService {

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    List<Star> selectList(StarVo starVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    Star selectOne(StarVo starVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    int insert(Star star);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    int update(Star star);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    int delete(Long id);

}
