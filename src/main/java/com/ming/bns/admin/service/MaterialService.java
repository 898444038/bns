package com.ming.bns.admin.service;

import com.ming.bns.admin.vo.MaterialVo;
import com.ming.bns.admin.entity.Material;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 材料
 * @author: Administrator
 * @date: 2020-07-16
 */
public interface MaterialService {

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    List<Material> selectList(MaterialVo materialVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    Material selectOne(MaterialVo materialVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    int insert(Material material);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    int update(Material material);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    int delete(Long id);

}
