package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.service.bns.EquipMaterialService;
import com.ming.bns.admin.vo.bns.EquipMaterialVo;
import com.ming.bns.admin.mapper.bns.EquipMaterialMapper;
import com.ming.bns.admin.entity.bns.EquipMaterial;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 装备材料
 * @author: Administrator
 * @date: 2020-08-03
 */
@Service
public class EquipMaterialServiceImpl implements EquipMaterialService {

    @Resource
    private EquipMaterialMapper equipMaterialMapper;

	@Override
	public Pagination<EquipMaterial> selectPage(EquipMaterialVo equipMaterialVo) {
        Pagination<EquipMaterial> pagination = new Pagination<>();
        int count = equipMaterialMapper.selectCount(equipMaterialVo);
        List<EquipMaterial> list = equipMaterialMapper.selectPage(equipMaterialVo);
        pagination.setPageNo(equipMaterialVo.getPageNo());
        pagination.setPageSize(equipMaterialVo.getPageSize());
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
    public List<EquipMaterial> selectList(EquipMaterialVo equipMaterialVo) {
        return equipMaterialMapper.selectList(equipMaterialVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public EquipMaterial selectOne(EquipMaterialVo equipMaterialVo) {
        return equipMaterialMapper.selectOne(equipMaterialVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int insert(EquipMaterial equipMaterial) {
        return equipMaterialMapper.insert(equipMaterial);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int update(EquipMaterial equipMaterial) {
        return equipMaterialMapper.update(equipMaterial);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Override
    public int delete(Long id) {
        return equipMaterialMapper.delete(id);
    }
}
