package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.TaskChallengeVo;
import com.ming.bns.admin.entity.bns.TaskChallenge;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;

/**
 * 任务挑战
 * @author: Administrator
 * @date: 2020-08-22
 */
public interface TaskChallengeService {

	Pagination<TaskChallenge> selectPage(TaskChallengeVo taskChallengeVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    List<TaskChallenge> selectList(TaskChallengeVo taskChallengeVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    TaskChallenge selectOne(TaskChallengeVo taskChallengeVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    int insert(TaskChallenge taskChallenge);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    int update(TaskChallenge taskChallenge);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    int delete(Long id);

}
