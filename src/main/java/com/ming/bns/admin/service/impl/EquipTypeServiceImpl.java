package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.entity.EquipType;
import com.ming.bns.admin.vo.EquipTypeVo;
import com.ming.bns.admin.service.EquipTypeService;
import com.ming.bns.admin.mapper.EquipTypeMapper;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备类型
 * @author: Administrator
 * @date: 2020-08-03
 */
@Service
public class EquipTypeServiceImpl implements EquipTypeService {

    @Resource
    private EquipTypeMapper equipTypeMapper;

	@Override
	public Pagination<EquipType> selectPage(EquipTypeVo equipTypeVo) {
        Pagination<EquipType> pagination = new Pagination<>();
        int count = equipTypeMapper.selectCount(equipTypeVo);
        List<EquipType> list = equipTypeMapper.selectPage(equipTypeVo);
        pagination.setPageNo(equipTypeVo.getPageNo());
        pagination.setPageSize(equipTypeVo.getPageSize());
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
    public List<EquipType> selectList(EquipTypeVo equipTypeVo) {
        return equipTypeMapper.selectList(equipTypeVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public EquipType selectOne(EquipTypeVo equipTypeVo) {
        return equipTypeMapper.selectOne(equipTypeVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int insert(EquipType equipType) {
        return equipTypeMapper.insert(equipType);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int update(EquipType equipType) {
        return equipTypeMapper.update(equipType);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int delete(Long id) {
        return equipTypeMapper.delete(id);
    }
}
