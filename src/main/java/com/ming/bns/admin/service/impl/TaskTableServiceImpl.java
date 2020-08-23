package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.service.TaskTableService;
import com.ming.bns.admin.vo.TaskTableVo;
import com.ming.bns.admin.mapper.TaskTableMapper;
import com.ming.bns.admin.entity.TaskTable;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务表
 * @author: Administrator
 * @date: 2020-08-22
 */
@Service
public class TaskTableServiceImpl implements TaskTableService {

    @Resource
    private TaskTableMapper taskTableMapper;

	@Override
	public Pagination<TaskTable> selectPage(TaskTableVo taskTableVo) {
        Pagination<TaskTable> pagination = new Pagination<>();
        int count = taskTableMapper.selectCount(taskTableVo);
        List<TaskTable> list = taskTableMapper.selectPage(taskTableVo);
        pagination.setPageNo(taskTableVo.getPageNo());
        pagination.setPageSize(taskTableVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public List<TaskTable> selectList(TaskTableVo taskTableVo) {
        return taskTableMapper.selectList(taskTableVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public TaskTable selectOne(TaskTableVo taskTableVo) {
        return taskTableMapper.selectOne(taskTableVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public int insert(TaskTable taskTable) {
        return taskTableMapper.insert(taskTable);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public int update(TaskTable taskTable) {
        return taskTableMapper.update(taskTable);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public int delete(Long id) {
        return taskTableMapper.delete(id);
    }


    @Override
    public int delete(TaskTableVo taskTableVo) {
        return taskTableMapper.deleteList(taskTableVo);
    }
}
