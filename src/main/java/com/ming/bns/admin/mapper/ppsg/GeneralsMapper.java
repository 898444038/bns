package com.ming.bns.admin.mapper.ppsg;

import com.ming.bns.admin.vo.ppsg.GeneralsVo;
import com.ming.bns.admin.entity.ppsg.Generals;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 武将表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Mapper
public interface GeneralsMapper {

    @TargetDataSource("dataSource2")
	int selectCount(GeneralsVo generalsVo);

    @TargetDataSource("dataSource2")
	List<Generals> selectPage(GeneralsVo generalsVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource2")
    List<Generals> selectList(GeneralsVo generalsVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource2")
    Generals selectOne(GeneralsVo generalsVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource2")
    int insert(Generals generals);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource2")
    int update(Generals generals);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @TargetDataSource("dataSource2")
    int delete(Long id);

}
