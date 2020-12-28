package com.ming.bns.admin.service.impl.sys;

import com.ming.bns.admin.entity.sys.User;
import com.ming.bns.admin.vo.sys.UserVo;
import com.ming.bns.admin.service.sys.UserService;
import com.ming.bns.admin.mapper.sys.UserMapper;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-16
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

	@Override
	public Pagination<User> selectPage(UserVo userVo) {
        Pagination<User> pagination = new Pagination<>();
        int count = userMapper.selectCount(userVo);
        List<User> list = userMapper.selectPage(userVo);
        pagination.setPageNo(userVo.getPageNo());
        pagination.setPageSize(userVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Override
    public List<User> selectList(UserVo userVo) {
        return userMapper.selectList(userVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Override
    public User selectOne(UserVo userVo) {
        return userMapper.selectOne(userVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }
}
