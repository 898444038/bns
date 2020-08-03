package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.entity.Equip;
import com.ming.bns.admin.service.EquipService;
import com.ming.bns.admin.vo.EquipVo;
import com.ming.bns.admin.mapper.EquipMapper;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备
 * @author: Administrator
 * @date: 2020-08-03
 */
@Service
public class EquipServiceImpl implements EquipService {

    @Resource
    private EquipMapper equipMapper;

	@Override
	public Pagination<Equip> selectPage(EquipVo equipVo) {
        Pagination<Equip> pagination = new Pagination<>();
        int count = equipMapper.selectCount(equipVo);
        List<Equip> list = equipMapper.selectPage(equipVo);
        pagination.setPageNo(equipVo.getPageNo());
        pagination.setPageSize(equipVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public List<Equip> selectList(EquipVo equipVo) {
        return equipMapper.selectList(equipVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public Equip selectOne(EquipVo equipVo) {
        return equipMapper.selectOne(equipVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int insert(Equip equip) {
        return equipMapper.insert(equip);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int update(Equip equip) {
        return equipMapper.update(equip);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int delete(Long id) {
        return equipMapper.delete(id);
    }
}
