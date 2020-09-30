package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.UpdateLogVo;
import com.ming.bns.admin.entity.bns.UpdateLog;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 更新日志
 * @author: Administrator
 * @date: 2020-08-26
 */
@Mapper
public interface UpdateLogMapper {

    @TargetDataSource("dataSource1")
	int selectCount(UpdateLogVo updateLogVo);

    @TargetDataSource("dataSource1")
	List<UpdateLog> selectPage(UpdateLogVo updateLogVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @TargetDataSource("dataSource1")
    List<UpdateLog> selectList(UpdateLogVo updateLogVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @TargetDataSource("dataSource1")
    UpdateLog selectOne(UpdateLogVo updateLogVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @TargetDataSource("dataSource1")
    int insert(UpdateLog updateLog);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @TargetDataSource("dataSource1")
    int update(UpdateLog updateLog);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
