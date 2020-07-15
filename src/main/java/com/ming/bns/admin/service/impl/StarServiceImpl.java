package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.entity.Star;
import com.ming.bns.admin.mapper.StarMapper;
import com.ming.bns.admin.vo.StarVo;
import com.ming.bns.admin.service.StarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-15
 */
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarMapper starMapper;

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @Override
    public List<Star> selectList(StarVo starVo) {
        return starMapper.selectList(starVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @Override
    public Star selectOne(StarVo starVo) {
        return starMapper.selectOne(starVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @Override
    public int insert(Star star) {
        return starMapper.insert(star);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @Override
    public int update(Star star) {
        return starMapper.update(star);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-15
	 */
    @Override
    public int delete(Long id) {
        return starMapper.delete(id);
    }
}
