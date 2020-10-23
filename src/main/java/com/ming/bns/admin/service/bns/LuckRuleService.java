package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.LuckRuleVo;
import com.ming.bns.admin.entity.bns.LuckRule;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖规则表
 * @author: Administrator
 * @date: 2020-10-23
 */
public interface LuckRuleService {

	Pagination<LuckRule> selectPage(LuckRuleVo luckRuleVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    List<LuckRule> selectList(LuckRuleVo luckRuleVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    LuckRule selectOne(LuckRuleVo luckRuleVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int insert(LuckRule luckRule);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int update(LuckRule luckRule);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int delete(Long id);

}
