package com.ming.bns.admin.controller.bns;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.service.bns.EquipGrowService;
import com.ming.bns.admin.entity.bns.EquipGrow;
import com.ming.bns.admin.service.bns.EquipItemService;
import com.ming.bns.admin.utils.EquipUtil;
import com.ming.bns.admin.vo.bns.EquipGrowVo;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.bns.EquipItemVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 装备成长
 * @author: Administrator
 * @date: 2020-08-03
 */
@RestController
@RequestMapping("/bns/equip/grow")
public class EquipGrowController {

    @Autowired
    private EquipGrowService equipGrowService;
    @Autowired
    private EquipItemService equipItemService;

    @Log("EquipGrow")
    @PostMapping("/auction")
    public ResultMsg auction(EquipGrowVo equipGrowVo){
        EquipItemVo itemVo = new EquipItemVo();
        itemVo.setType(equipGrowVo.getType());
        List<EquipItem> equipAllList = equipItemService.selectList(itemVo);
        List<EquipGrow> equipGrowList = new ArrayList<>();
        for(EquipItem item : equipAllList){
            if(item.getParentId()!=0){
                equipGrowList.add(new EquipGrow(item.getParentId(),item.getId()));
            }
        }

        List<EquipItem> childrenList = equipAllList.stream().filter(s-> StringUtils.isNotBlank(s.getChildren())).collect(Collectors.toList());
        List<EquipItem> equipItemList = new ArrayList<>();
        for(EquipItem item : childrenList){
            String[] childrens = item.getChildren().split(",");
            for(String children : childrens){
                List<EquipItem> items = equipAllList.stream().filter(s->s.getId().toString().equals(children)).collect(Collectors.toList());
                EquipItem equipItem = new EquipItem();
                equipItem.setId(items.get(0).getId());
                equipItem.setEquipId(items.get(0).getEquipId());
                equipItem.setName(items.get(0).getName());
                equipItem.setParentId(item.getId());
                equipItem.setType(0);
                equipItemList.add(equipItem);
                equipGrowList.add(new EquipGrow(equipItem.getParentId(),equipItem.getId()));
            }
        }
        equipAllList.addAll(equipItemList);

        Long startId = 225L;
        Long endId = 233L;

        List<List<EquipItem>> routeList = EquipUtil.routeTree(startId,endId,equipAllList,equipGrowList);
        System.out.println();
        for(List<EquipItem> route : routeList){
            EquipUtil.routeCount(route);
        }
        return ResultMsg.success();
    }


    @Log("EquipGrow")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(EquipGrowVo equipGrowVo){
        Pagination<EquipGrow> pagination = equipGrowService.selectPage(equipGrowVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipGrow")
    @GetMapping("/selectList")
    public ResultMsg selectList(EquipGrowVo equipGrowVo){
        return ResultMsg.success(equipGrowService.selectList(equipGrowVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipGrow")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(EquipGrowVo equipGrowVo){
        return ResultMsg.success(equipGrowService.selectOne(equipGrowVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipGrow")
    @PostMapping("/insert")
    public ResultMsg insert(EquipGrow equipGrow){
        if(equipGrow == null){
            return ResultMsg.failed();
        }
        int i = equipGrowService.insert(equipGrow);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipGrow")
    @PostMapping("/update")
    public ResultMsg update(EquipGrow equipGrow){
        if(equipGrow == null || equipGrow.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipGrowService.update(equipGrow);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipGrow")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipGrowService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
