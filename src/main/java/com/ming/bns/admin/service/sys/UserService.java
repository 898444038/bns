package com.ming.bns.admin.service.sys;

import com.ming.bns.admin.entity.sys.User;
import com.ming.bns.admin.vo.sys.UserVo;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-16
 */
public interface UserService {

	Pagination<User> selectPage(UserVo userVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    List<User> selectList(UserVo userVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    User selectOne(UserVo userVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    int insert(User user);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    int update(User user);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    int delete(Long id);

}
