package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.vo.bns.EquipMaterialVo;
import com.ming.bns.admin.entity.bns.EquipMaterial;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;

/**
 * 装备材料
 * @author: Administrator
 * @date: 2020-08-03
 */
public interface EquipMaterialService {

	Pagination<EquipMaterial> selectPage(EquipMaterialVo equipMaterialVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    List<EquipMaterial> selectList(EquipMaterialVo equipMaterialVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    EquipMaterial selectOne(EquipMaterialVo equipMaterialVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int insert(EquipMaterial equipMaterial);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int update(EquipMaterial equipMaterial);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int delete(Long id);

}
