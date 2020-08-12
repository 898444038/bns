package com.ming.bns.admin.service;

import com.ming.bns.admin.vo.StatisticsItemVo;
import com.ming.bns.admin.entity.StatisticsItem;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 统计项
 * @author: Administrator
 * @date: 2020-08-12
 */
public interface StatisticsItemService {

	Pagination<StatisticsItem> selectPage(StatisticsItemVo statisticsItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    List<StatisticsItem> selectList(StatisticsItemVo statisticsItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    StatisticsItem selectOne(StatisticsItemVo statisticsItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int insert(StatisticsItem statisticsItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int update(StatisticsItem statisticsItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int delete(Long id);

}
