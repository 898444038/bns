package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.service.EquipGrowService;
import com.ming.bns.admin.entity.EquipGrow;
import com.ming.bns.admin.vo.EquipGrowVo;
import com.ming.bns.admin.mapper.EquipGrowMapper;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备成长
 * @author: Administrator
 * @date: 2020-08-03
 */
@Service
public class EquipGrowServiceImpl implements EquipGrowService {

    @Resource
    private EquipGrowMapper equipGrowMapper;

	@Override
	public Pagination<EquipGrow> selectPage(EquipGrowVo equipGrowVo) {
        Pagination<EquipGrow> pagination = new Pagination<>();
        int count = equipGrowMapper.selectCount(equipGrowVo);
        List<EquipGrow> list = equipGrowMapper.selectPage(equipGrowVo);
        pagination.setPageNo(equipGrowVo.getPageNo());
        pagination.setPageSize(equipGrowVo.getPageSize());
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
    public List<EquipGrow> selectList(EquipGrowVo equipGrowVo) {
        return equipGrowMapper.selectList(equipGrowVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public EquipGrow selectOne(EquipGrowVo equipGrowVo) {
        return equipGrowMapper.selectOne(equipGrowVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int insert(EquipGrow equipGrow) {
        return equipGrowMapper.insert(equipGrow);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int update(EquipGrow equipGrow) {
        return equipGrowMapper.update(equipGrow);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int delete(Long id) {
        return equipGrowMapper.delete(id);
    }
}
