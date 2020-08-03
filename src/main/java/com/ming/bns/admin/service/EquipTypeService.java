package com.ming.bns.admin.service;

import com.ming.bns.admin.entity.EquipType;
import com.ming.bns.admin.vo.EquipTypeVo;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备类型
 * @author: Administrator
 * @date: 2020-08-03
 */
public interface EquipTypeService {

	Pagination<EquipType> selectPage(EquipTypeVo equipTypeVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    List<EquipType> selectList(EquipTypeVo equipTypeVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    EquipType selectOne(EquipTypeVo equipTypeVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int insert(EquipType equipType);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int update(EquipType equipType);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int delete(Long id);

}
