package com.ming.bns.admin.mapper;

import com.ming.bns.admin.vo.TaskTableVo;
import com.ming.bns.admin.entity.TaskTable;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 任务表
 * @author: Administrator
 * @date: 2020-08-22
 */
@Mapper
public interface TaskTableMapper {

    @TargetDataSource("dataSource1")
	int selectCount(TaskTableVo taskTableVo);

    @TargetDataSource("dataSource1")
	List<TaskTable> selectPage(TaskTableVo taskTableVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    List<TaskTable> selectList(TaskTableVo taskTableVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    TaskTable selectOne(TaskTableVo taskTableVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    int insert(TaskTable taskTable);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    int update(TaskTable taskTable);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

	@TargetDataSource("dataSource1")
	int deleteList(TaskTableVo taskTableVo);
}
