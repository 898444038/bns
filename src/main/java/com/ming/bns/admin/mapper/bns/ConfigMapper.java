package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.ConfigVo;
import com.ming.bns.admin.entity.bns.Config;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 配置表
 * @author: Administrator
 * @date: 2020-08-25
 */
@Mapper
public interface ConfigMapper {

    @TargetDataSource("dataSource1")
	int selectCount(ConfigVo configVo);

    @TargetDataSource("dataSource1")
	List<Config> selectPage(ConfigVo configVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    List<Config> selectList(ConfigVo configVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    Config selectOne(ConfigVo configVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    int insert(Config config);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    int update(Config config);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
