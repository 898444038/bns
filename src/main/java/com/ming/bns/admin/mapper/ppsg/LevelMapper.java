package com.ming.bns.admin.mapper.ppsg;

import com.ming.bns.admin.vo.ppsg.LevelVo;
import com.ming.bns.admin.entity.ppsg.Level;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 等级表
 * @author: Administrator
 * @date: 2020-09-30
 */
@Mapper
public interface LevelMapper {

    @TargetDataSource("dataSource2")
	int selectCount(LevelVo levelVo);

    @TargetDataSource("dataSource2")
	List<Level> selectPage(LevelVo levelVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @TargetDataSource("dataSource2")
    List<Level> selectList(LevelVo levelVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @TargetDataSource("dataSource2")
    Level selectOne(LevelVo levelVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @TargetDataSource("dataSource2")
    int insert(Level level);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @TargetDataSource("dataSource2")
    int update(Level level);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @TargetDataSource("dataSource2")
    int delete(Long id);

}
