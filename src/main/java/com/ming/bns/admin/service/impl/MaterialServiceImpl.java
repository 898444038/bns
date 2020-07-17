package com.ming.bns.admin.service.impl;

import com.ming.bns.admin.mapper.MaterialMapper;
import com.ming.bns.admin.vo.MaterialVo;
import com.ming.bns.admin.service.MaterialService;
import com.ming.bns.admin.entity.Material;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 材料
 * @author: Administrator
 * @date: 2020-07-16
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Resource
    private MaterialMapper materialMapper;

	/**
	 * 查询分页列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Override
	public List<Material> selectPage(MaterialVo materialVo) {
		return materialMapper.selectPage(materialVo);
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @Override
    public List<Material> selectList(MaterialVo materialVo) {
        return materialMapper.selectList(materialVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @Override
    public Material selectOne(MaterialVo materialVo) {
        return materialMapper.selectOne(materialVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @Override
    public int insert(Material material) {
        return materialMapper.insert(material);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @Override
    public int update(Material material) {
        return materialMapper.update(material);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
    @Override
    public int delete(Long id) {
        return materialMapper.delete(id);
    }
}
