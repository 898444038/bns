package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.mapper.bns.EquipItemMapper;
import com.ming.bns.admin.service.bns.EquipGrowService;
import com.ming.bns.admin.entity.bns.EquipGrow;
import com.ming.bns.admin.vo.bns.EquipGrowVo;
import com.ming.bns.admin.mapper.bns.EquipGrowMapper;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;

import com.ming.bns.admin.vo.bns.EquipItemVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 装备成长
 * @author: Administrator
 * @date: 2020-08-03
 */
@Service
public class EquipGrowServiceImpl implements EquipGrowService {

    @Resource
    private EquipGrowMapper equipGrowMapper;
    @Resource
    private EquipItemMapper equipItemMapper;

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

    @Override
    public int refresh(EquipItemVo equipItemVo) {
        EquipItemVo itemVo = new EquipItemVo();
        itemVo.setType(equipItemVo.getType());
        List<EquipItem> allList = equipItemMapper.selectList(itemVo);
        itemVo.setEquipId(equipItemVo.getEquipId());
        List<EquipItem> equipAllList = equipItemMapper.selectList(itemVo);
        List<EquipGrow> equipGrowList = new ArrayList<>();
        for(EquipItem item : equipAllList){
            if(item.getParentId()!=0){
                //equipGrowList.add(new EquipGrow(equipItemVo.getEquipId(),equipItemVo.getType(),item.getParentId(),item.getId()));
                Integer sort = 0;
                Long equipId = null;
                for(EquipItem item2 : equipAllList){
                    if(item.getParentId().equals(item2.getId())){
                        sort = item2.getSort();
                        equipId = item2.getEquipId();
                        break;
                    }
                }
                EquipGrow equipGrow = new EquipGrow(equipId,item.getEquipId(),equipItemVo.getType(),sort.longValue(),item.getSort().longValue());
                //equipGrowList.add(equipGrow);
                handle(equipGrow);
            }
        }
        List<EquipItem> childrenList = equipAllList.stream().filter(s-> StringUtils.isNotBlank(s.getChildren())).collect(Collectors.toList());
        for(EquipItem item : childrenList){
            String[] childrens = item.getChildren().split(",");
            for(String children : childrens){
                List<EquipItem> items = allList.stream().filter(s->s.getId().toString().equals(children)).collect(Collectors.toList());
                EquipGrow equipGrow = new EquipGrow(item.getEquipId(),items.get(0).getEquipId(),equipItemVo.getType(),item.getSort().longValue(),items.get(0).getSort().longValue());
                //equipGrowList.add(equipGrow);
                handle(equipGrow);
            }
        }
//        equipGrowMapper.deleteByType(equipItemVo.getType(),equipItemVo.getEquipId());
//        return equipGrowMapper.insertBatch(equipGrowList);
        return 1;
    }

    public void handle(EquipGrow equipGrow){
        EquipGrowVo equipGrowVo = new EquipGrowVo();
        equipGrowVo.setType(equipGrow.getType());
        equipGrowVo.setStartSort(equipGrow.getStartSort());
        equipGrowVo.setEndSort(equipGrow.getEndSort());
        EquipGrow grow = equipGrowMapper.selectOne(equipGrowVo);
        if(grow == null){
            equipGrowMapper.insert(equipGrow);
        }else{
            if(!equipGrow.getEquipId().equals(grow.getEquipId()) || !equipGrow.getEquipId2().equals(grow.getEquipId2())){
                grow.setEquipId(equipGrow.getEquipId());
                grow.setEquipId2(equipGrow.getEquipId2());
                equipGrowMapper.update(grow);
            }
        }
    }
}
