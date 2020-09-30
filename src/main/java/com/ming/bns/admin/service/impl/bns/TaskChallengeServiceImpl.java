package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.service.bns.TaskChallengeService;
import com.ming.bns.admin.mapper.bns.TaskChallengeMapper;
import com.ming.bns.admin.vo.bns.TaskChallengeVo;
import com.ming.bns.admin.entity.bns.TaskChallenge;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务挑战
 * @author: Administrator
 * @date: 2020-08-22
 */
@Service
public class TaskChallengeServiceImpl implements TaskChallengeService {

    @Resource
    private TaskChallengeMapper taskChallengeMapper;

	@Override
	public Pagination<TaskChallenge> selectPage(TaskChallengeVo taskChallengeVo) {
        Pagination<TaskChallenge> pagination = new Pagination<>();
        int count = taskChallengeMapper.selectCount(taskChallengeVo);
        List<TaskChallenge> list = taskChallengeMapper.selectPage(taskChallengeVo);
        pagination.setPageNo(taskChallengeVo.getPageNo());
        pagination.setPageSize(taskChallengeVo.getPageSize());
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
    public List<TaskChallenge> selectList(TaskChallengeVo taskChallengeVo) {
        return taskChallengeMapper.selectList(taskChallengeVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public TaskChallenge selectOne(TaskChallengeVo taskChallengeVo) {
        return taskChallengeMapper.selectOne(taskChallengeVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public int insert(TaskChallenge taskChallenge) {
        return taskChallengeMapper.insert(taskChallenge);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public int update(TaskChallenge taskChallenge) {
        return taskChallengeMapper.update(taskChallenge);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-22
	 */
    @Override
    public int delete(Long id) {
        return taskChallengeMapper.delete(id);
    }
}
