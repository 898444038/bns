package com.ming.bns.admin.mapper;

import com.ming.bns.admin.entity.Star;
import com.ming.bns.admin.vo.StarVo;

import com.ming.bns.system.config.datasource.TargetDataSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-19
 */
@Mapper
public interface StarMapper {

	@TargetDataSource("dataSource1")
	int selectCount(StarVo starVo);

	@TargetDataSource("dataSource1")
	List<Star> selectPage(StarVo starVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
	@TargetDataSource("dataSource1")
    List<Star> selectList(StarVo starVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
	@TargetDataSource("dataSource1")
    Star selectOne(StarVo starVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
	@TargetDataSource("dataSource1")
    int insert(Star star);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
	@TargetDataSource("dataSource1")
    int update(Star star);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-19
	 */
	@TargetDataSource("dataSource1")
    int delete(Long id);

}
