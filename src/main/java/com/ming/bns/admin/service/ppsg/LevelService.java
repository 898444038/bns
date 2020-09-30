package com.ming.bns.admin.service.ppsg;

import com.ming.bns.admin.vo.ppsg.LevelVo;
import com.ming.bns.admin.entity.ppsg.Level;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 等级表
 * @author: Administrator
 * @date: 2020-09-30
 */
public interface LevelService {

	Pagination<Level> selectPage(LevelVo levelVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    List<Level> selectList(LevelVo levelVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    Level selectOne(LevelVo levelVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    int insert(Level level);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    int update(Level level);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    int delete(Long id);

}
