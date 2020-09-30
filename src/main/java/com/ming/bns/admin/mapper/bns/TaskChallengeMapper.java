package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.TaskChallengeVo;
import com.ming.bns.admin.entity.bns.TaskChallenge;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 任务挑战
 * @author: Administrator
 * @date: 2020-08-22
 */
@Mapper
public interface TaskChallengeMapper {

    @TargetDataSource("dataSource1")
	int selectCount(TaskChallengeVo taskChallengeVo);

    @TargetDataSource("dataSource1")
	List<TaskChallenge> selectPage(TaskChallengeVo taskChallengeVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    List<TaskChallenge> selectList(TaskChallengeVo taskChallengeVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    TaskChallenge selectOne(TaskChallengeVo taskChallengeVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    int insert(TaskChallenge taskChallenge);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    int update(TaskChallenge taskChallenge);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
