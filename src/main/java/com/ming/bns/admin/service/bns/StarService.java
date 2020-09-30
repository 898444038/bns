package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.entity.bns.Star;
import com.ming.bns.admin.vo.bns.StarVo;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;
import java.util.Map;

/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-19
 */
public interface StarService {

	Pagination<Star> selectPage(StarVo starVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    List<Star> selectList(StarVo starVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    Star selectOne(StarVo starVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    int insert(Star star);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    int update(Star star);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
    int delete(Long id);

	Map<String, Object> countStarExp(StarVo starVo);
}
