package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.entity.bns.Equip;
import com.ming.bns.admin.vo.bns.EquipVo;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;

/**
 * 装备
 * @author: Administrator
 * @date: 2020-08-03
 */
public interface EquipService {

	Pagination<Equip> selectPage(EquipVo equipVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    List<Equip> selectList(EquipVo equipVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    Equip selectOne(EquipVo equipVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int insert(Equip equip);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int update(Equip equip);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int delete(Long id);

}
