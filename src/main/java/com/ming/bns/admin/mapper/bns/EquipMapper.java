package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.entity.bns.Equip;
import com.ming.bns.admin.vo.bns.EquipVo;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 装备
 * @author: Administrator
 * @date: 2020-08-03
 */
@Mapper
public interface EquipMapper {

    @TargetDataSource("dataSource1")
	int selectCount(EquipVo equipVo);

    @TargetDataSource("dataSource1")
	List<Equip> selectPage(EquipVo equipVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    List<Equip> selectList(EquipVo equipVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    Equip selectOne(EquipVo equipVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int insert(Equip equip);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int update(Equip equip);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
