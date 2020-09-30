package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.vo.bns.MaterialVo;
import com.ming.bns.admin.entity.bns.Material;

import java.util.List;

/**
 * 材料
 * @author: Administrator
 * @date: 2020-07-16
 */
public interface MaterialService {

	/**
	 * 查询分页列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	Pagination<Material> selectPage(MaterialVo materialVo);

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

	List<Material> simpleList(MaterialVo materialVo);
}
