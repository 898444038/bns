package com.ming.bns.admin.service.ppsg;

import com.ming.bns.admin.vo.ppsg.GeneralsVo;
import com.ming.bns.admin.entity.ppsg.Generals;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 武将表
 * @author: Administrator
 * @date: 2020-10-23
 */
public interface GeneralsService {

	Pagination<Generals> selectPage(GeneralsVo generalsVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    List<Generals> selectList(GeneralsVo generalsVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    Generals selectOne(GeneralsVo generalsVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int insert(Generals generals);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int update(Generals generals);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    int delete(Long id);

}
