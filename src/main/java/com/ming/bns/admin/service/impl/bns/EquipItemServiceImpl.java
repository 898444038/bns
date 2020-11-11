package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.mapper.bns.EquipItemMapper;
import com.ming.bns.admin.service.bns.EquipItemService;
import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.vo.bns.EquipItemVo;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备项
 * @author: Administrator
 * @date: 2020-11-11
 */
@Service
public class EquipItemServiceImpl implements EquipItemService {

    @Resource
    private EquipItemMapper equipItemMapper;

	@Override
	public Pagination<EquipItem> selectPage(EquipItemVo equipItemVo) {
        Pagination<EquipItem> pagination = new Pagination<>();
        int count = equipItemMapper.selectCount(equipItemVo);
        List<EquipItem> list = equipItemMapper.selectPage(equipItemVo);
        pagination.setPageNo(equipItemVo.getPageNo());
        pagination.setPageSize(equipItemVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public List<EquipItem> selectList(EquipItemVo equipItemVo) {
        return equipItemMapper.selectList(equipItemVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public EquipItem selectOne(EquipItemVo equipItemVo) {
        return equipItemMapper.selectOne(equipItemVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public int insert(EquipItem equipItem) {
        return equipItemMapper.insert(equipItem);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public int update(EquipItem equipItem) {
        return equipItemMapper.update(equipItem);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public int delete(Long id) {
        return equipItemMapper.delete(id);
    }
}
