package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.ConfigVo;
import com.ming.bns.admin.entity.bns.Config;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;

/**
 * 配置表
 * @author: Administrator
 * @date: 2020-08-25
 */
public interface ConfigService {

	Pagination<Config> selectPage(ConfigVo configVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    List<Config> selectList(ConfigVo configVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    Config selectOne(ConfigVo configVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    int insert(Config config);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    int update(Config config);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    int delete(Long id);

}
