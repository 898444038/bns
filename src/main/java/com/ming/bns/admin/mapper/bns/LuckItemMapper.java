package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.LuckItemVo;
import com.ming.bns.admin.entity.bns.LuckItem;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 抽奖项表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Mapper
public interface LuckItemMapper {

    @TargetDataSource("dataSource1")
	int selectCount(LuckItemVo luckItemVo);

    @TargetDataSource("dataSource1")
	List<LuckItem> selectPage(LuckItemVo luckItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    List<LuckItem> selectList(LuckItemVo luckItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    LuckItem selectOne(LuckItemVo luckItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int insert(LuckItem luckItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int update(LuckItem luckItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
