package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.LuckRuleVo;
import com.ming.bns.admin.entity.bns.LuckRule;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 抽奖规则表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Mapper
public interface LuckRuleMapper {

    @TargetDataSource("dataSource1")
	int selectCount(LuckRuleVo luckRuleVo);

    @TargetDataSource("dataSource1")
	List<LuckRule> selectPage(LuckRuleVo luckRuleVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    List<LuckRule> selectList(LuckRuleVo luckRuleVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    LuckRule selectOne(LuckRuleVo luckRuleVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int insert(LuckRule luckRule);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int update(LuckRule luckRule);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
