package com.ming.bns.admin.mapper;

import com.ming.bns.admin.vo.ChivalrousVo;
import com.ming.bns.admin.entity.Chivalrous;

import com.ming.bns.system.config.datasource.TargetDataSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 侠义团等级
 * @author: Administrator
 * @date: 2020-07-21
 */
@Mapper
public interface ChivalrousMapper {

    @TargetDataSource("dataSource1")
	int selectCount(ChivalrousVo chivalrousVo);

    @TargetDataSource("dataSource1")
	List<Chivalrous> selectPage(ChivalrousVo chivalrousVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @TargetDataSource("dataSource1")
    List<Chivalrous> selectList(ChivalrousVo chivalrousVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @TargetDataSource("dataSource1")
    Chivalrous selectOne(ChivalrousVo chivalrousVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @TargetDataSource("dataSource1")
    int insert(Chivalrous chivalrous);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @TargetDataSource("dataSource1")
    int update(Chivalrous chivalrous);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-21
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
