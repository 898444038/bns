package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.LuckVo;
import com.ming.bns.admin.entity.bns.Luck;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 抽奖表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Mapper
public interface LuckMapper {

    @TargetDataSource("dataSource1")
	int selectCount(LuckVo luckVo);

    @TargetDataSource("dataSource1")
	List<Luck> selectPage(LuckVo luckVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    List<Luck> selectList(LuckVo luckVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    Luck selectOne(LuckVo luckVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int insert(Luck luck);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int update(Luck luck);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
