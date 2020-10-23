package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.LuckVo;
import com.ming.bns.admin.entity.bns.Luck;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖表
 * @author: Administrator
 * @date: 2020-10-23
 */
public interface LuckService {

	Pagination<Luck> selectPage(LuckVo luckVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    List<Luck> selectList(LuckVo luckVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    Luck selectOne(LuckVo luckVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int insert(Luck luck);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int update(Luck luck);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int delete(Long id);

}
