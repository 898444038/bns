package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.entity.bns.Equip;
import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.mapper.bns.EquipItemMapper;
import com.ming.bns.admin.mapper.bns.EquipMapper;
import com.ming.bns.admin.vo.bns.EquipItemVo;
import com.ming.bns.admin.vo.bns.EquipVo;
import com.ming.bns.admin.service.bns.EquipService;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 装备
 * @author: Administrator
 * @date: 2020-11-11
 */
@Service
public class EquipServiceImpl implements EquipService {

    @Resource
    private EquipMapper equipMapper;
    @Resource
    private EquipItemMapper equipItemMapper;

	@Override
	public Pagination<Equip> selectPage(EquipVo equipVo) {
        Pagination<Equip> pagination = new Pagination<>();
        int count = equipMapper.selectCount(equipVo);
        List<Equip> list = equipMapper.selectPage(equipVo);
        for (Equip equip : list){
            EquipItemVo equipItemVo = new EquipItemVo();
            equipItemVo.setEquipId(equip.getId());
            List<EquipItem> items = equipItemMapper.selectList(equipItemVo);
            items = items.stream().sorted((c1,c2)->Long.compare(c1.getSort(),c2.getSort())).collect(Collectors.toList());
            equip.setItems(items);

            List<EquipItem> equipItems = items.stream().filter(s-> StringUtils.isNotBlank(s.getChildren())).collect(Collectors.toList());
            List<Map<String, Object>> mapList = new ArrayList<>();
            for(EquipItem equipItem : equipItems){
                Map<String,Object> map = new HashMap<>();
                map.put("id",equipItem);
                EquipItemVo vo = new EquipItemVo();
                vo.setChildrenIds(equipItem.getChildren());
                map.put("children",equipItemMapper.selectList(vo));
                mapList.add(map);
            }
            equip.setRelationItems(mapList);
        }
        pagination.setPageNo(equipVo.getPageNo());
        pagination.setPageSize(equipVo.getPageSize());
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
    public List<Equip> selectList(EquipVo equipVo) {
        return equipMapper.selectList(equipVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public Equip selectOne(EquipVo equipVo) {
        return equipMapper.selectOne(equipVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public int insert(Equip equip) {
        return equipMapper.insert(equip);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public int update(Equip equip) {
        return equipMapper.update(equip);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Override
    public int delete(Long id) {
        return equipMapper.delete(id);
    }
}
