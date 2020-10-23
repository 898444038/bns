package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.LuckItemVo;
import com.ming.bns.admin.entity.bns.LuckItem;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖项表
 * @author: Administrator
 * @date: 2020-10-23
 */
public interface LuckItemService {

	Pagination<LuckItem> selectPage(LuckItemVo luckItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    List<LuckItem> selectList(LuckItemVo luckItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    LuckItem selectOne(LuckItemVo luckItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int insert(LuckItem luckItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int update(LuckItem luckItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int delete(Long id);

}
