package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.entity.bns.Equip;
import com.ming.bns.admin.vo.bns.EquipVo;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备
 * @author: Administrator
 * @date: 2020-11-11
 */
public interface EquipService {

	Pagination<Equip> selectPage(EquipVo equipVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    List<Equip> selectList(EquipVo equipVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    Equip selectOne(EquipVo equipVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    int insert(Equip equip);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    int update(Equip equip);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    int delete(Long id);

}
