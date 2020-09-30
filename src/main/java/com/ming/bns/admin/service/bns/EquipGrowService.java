package com.ming.bns.admin.service.bns;

import com.ming.bns.admin.entity.bns.EquipGrow;
import com.ming.bns.admin.vo.bns.EquipGrowVo;

import com.ming.bns.admin.utils.Pagination;

import java.util.List;

/**
 * 装备成长
 * @author: Administrator
 * @date: 2020-08-03
 */
public interface EquipGrowService {

	Pagination<EquipGrow> selectPage(EquipGrowVo equipGrowVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    List<EquipGrow> selectList(EquipGrowVo equipGrowVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    EquipGrow selectOne(EquipGrowVo equipGrowVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int insert(EquipGrow equipGrow);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int update(EquipGrow equipGrow);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    int delete(Long id);

}
