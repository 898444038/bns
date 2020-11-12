package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.vo.bns.EquipItemVo;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 装备项
 * @author: Administrator
 * @date: 2020-11-11
 */
@Mapper
public interface EquipItemMapper {

    @TargetDataSource("dataSource1")
	int selectCount(EquipItemVo equipItemVo);

    @TargetDataSource("dataSource1")
	List<EquipItem> selectPage(EquipItemVo equipItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @TargetDataSource("dataSource1")
    List<EquipItem> selectList(EquipItemVo equipItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @TargetDataSource("dataSource1")
    EquipItem selectOne(EquipItemVo equipItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @TargetDataSource("dataSource1")
    int insert(EquipItem equipItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @TargetDataSource("dataSource1")
    int update(EquipItem equipItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

	@TargetDataSource("dataSource1")
    int deleteItems(Long equipId);
}
