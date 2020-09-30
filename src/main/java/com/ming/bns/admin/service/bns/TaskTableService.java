package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.TaskTableVo;
import com.ming.bns.admin.entity.bns.TaskTable;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;

/**
 * 任务表
 * @author: Administrator
 * @date: 2020-08-22
 */
public interface TaskTableService {

	Pagination<TaskTable> selectPage(TaskTableVo taskTableVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    List<TaskTable> selectList(TaskTableVo taskTableVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    TaskTable selectOne(TaskTableVo taskTableVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    int insert(TaskTable taskTable);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    int update(TaskTable taskTable);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    int delete(Long id);
    int delete(TaskTableVo taskTableVo);

}
