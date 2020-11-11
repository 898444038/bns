package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.vo.bns.EquipItemVo;

import com.ming.bns.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备项
 * @author: Administrator
 * @date: 2020-11-11
 */
public interface EquipItemService {

	Pagination<EquipItem> selectPage(EquipItemVo equipItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    List<EquipItem> selectList(EquipItemVo equipItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    EquipItem selectOne(EquipItemVo equipItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    int insert(EquipItem equipItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    int update(EquipItem equipItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    int delete(Long id);

}
