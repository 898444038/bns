package com.ming.bns.admin.mapper;

import com.ming.bns.admin.entity.EquipGrow;
import com.ming.bns.admin.vo.EquipGrowVo;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 装备成长
 * @author: Administrator
 * @date: 2020-08-03
 */
@Mapper
public interface EquipGrowMapper {

    @TargetDataSource("dataSource1")
	int selectCount(EquipGrowVo equipGrowVo);

    @TargetDataSource("dataSource1")
	List<EquipGrow> selectPage(EquipGrowVo equipGrowVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    List<EquipGrow> selectList(EquipGrowVo equipGrowVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    EquipGrow selectOne(EquipGrowVo equipGrowVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int insert(EquipGrow equipGrow);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int update(EquipGrow equipGrow);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
