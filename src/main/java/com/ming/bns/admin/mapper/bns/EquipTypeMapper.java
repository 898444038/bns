package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.EquipTypeVo;
import com.ming.bns.admin.entity.bns.EquipType;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 装备类型
 * @author: Administrator
 * @date: 2020-08-03
 */
@Mapper
public interface EquipTypeMapper {

    @TargetDataSource("dataSource1")
	int selectCount(EquipTypeVo equipTypeVo);

    @TargetDataSource("dataSource1")
	List<EquipType> selectPage(EquipTypeVo equipTypeVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    List<EquipType> selectList(EquipTypeVo equipTypeVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    EquipType selectOne(EquipTypeVo equipTypeVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int insert(EquipType equipType);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int update(EquipType equipType);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
