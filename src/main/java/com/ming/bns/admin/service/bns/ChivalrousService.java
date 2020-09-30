package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.entity.bns.Chivalrous;
import com.ming.bns.admin.vo.bns.ChivalrousVo;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;
import java.util.Map;

/**
 * 侠义团等级
 * @author: Administrator
 * @date: 2020-07-21
 */
public interface ChivalrousService {

	Pagination<Chivalrous> selectPage(ChivalrousVo chivalrousVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    List<Chivalrous> selectList(ChivalrousVo chivalrousVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    Chivalrous selectOne(ChivalrousVo chivalrousVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    int insert(Chivalrous chivalrous);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    int update(Chivalrous chivalrous);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    int delete(Long id);

	Map<String, Object> countExp(ChivalrousVo chivalrousVo);
}
