package com.ming.bns.admin.mapper.bns;

import com.ming.bns.admin.vo.bns.EquipMaterialVo;
import com.ming.bns.admin.entity.bns.EquipMaterial;

import org.apache.ibatis.annotations.Mapper;
import com.ming.bns.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 装备材料
 * @author: Administrator
 * @date: 2020-08-03
 */
@Mapper
public interface EquipMaterialMapper {

    @TargetDataSource("dataSource1")
	int selectCount(EquipMaterialVo equipMaterialVo);

    @TargetDataSource("dataSource1")
	List<EquipMaterial> selectPage(EquipMaterialVo equipMaterialVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    List<EquipMaterial> selectList(EquipMaterialVo equipMaterialVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    EquipMaterial selectOne(EquipMaterialVo equipMaterialVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int insert(EquipMaterial equipMaterial);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int update(EquipMaterial equipMaterial);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
