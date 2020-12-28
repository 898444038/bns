package com.ming.bns.admin.controller.bns;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.entity.bns.EquipMaterial;
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
import java.util.Map;
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
    @PostMapping("/options")
    public ResultMsg options(EquipGrowVo equipGrowVo){
        EquipItemVo equipItemVo = new EquipItemVo();
        equipItemVo.setType(equipGrowVo.getType());
        List<EquipItem> itemList = equipItemService.selectList(equipItemVo);
        return ResultMsg.success(itemList);
    }

    @Log("EquipGrow")
    @PostMapping("/auction")
    public ResultMsg auction(EquipGrowVo equipGrowVo){
        Long startId = equipGrowVo.getStartId();
        Long endId = equipGrowVo.getEndId();
        if(equipGrowVo.getType()==null || startId==null || endId==null){
            ResultMsg.failed();
        }

        List<EquipGrow> equipGrowList = equipGrowService.selectList(equipGrowVo);
        EquipItemVo equipItemVo = new EquipItemVo();
        equipItemVo.setType(equipGrowVo.getType());
        List<EquipItem> itemList = equipItemService.selectList(equipItemVo);
        List<EquipItem> equipAllList = new ArrayList<>();
        for (EquipItem equipItem : itemList){
            equipAllList.add(equipItem);
            if(StringUtils.isNotBlank(equipItem.getChildren())){
                String[] childrens = equipItem.getChildren().split(",");
                for(String children : childrens){
                    List<EquipItem> items1 = itemList.stream().filter(s->children.equals(s.getId().toString())).collect(Collectors.toList());
                    EquipItem equipItem1 = new EquipItem();
                    equipItem1.setId(items1.get(0).getId());
                    equipItem1.setName(items1.get(0).getName());
                    equipItem1.setParentId(equipItem.getId());
                    equipAllList.add(equipItem1);
                }
            }
        }

        Map<String,Object> map = EquipUtil.routeTree(startId,endId,equipAllList,equipGrowList);
        return ResultMsg.success(map);
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
        List<EquipGrow> equipGrowList = equipGrowService.selectList(equipGrowVo);
        EquipItemVo equipItemVo = new EquipItemVo();
        equipItemVo.setType(equipGrowVo.getType());
        List<EquipItem> itemList = equipItemService.selectList(equipItemVo);
        for(EquipGrow equipGrow : equipGrowList){
            List<EquipItem> items1 = itemList.stream().filter(s->equipGrow.getEquipId().equals(s.getEquipId()) && equipGrow.getStartSort().equals(s.getSort().longValue())).collect(Collectors.toList());
            List<EquipItem> items2 = itemList.stream().filter(s->equipGrow.getEquipId2().equals(s.getEquipId()) && equipGrow.getEndSort().equals(s.getSort().longValue())).collect(Collectors.toList());
            EquipItem item1 = items1.get(0);
            EquipItem item2 = items2.get(0);
            equipGrow.setStartItemName(item1.getName());
            equipGrow.setEndItemName(item2.getName());
            if(StringUtils.isNotBlank(equipGrow.getMaterials())){
                Gson gson = new Gson();
                List<EquipMaterial> list = gson.fromJson(equipGrow.getMaterials(), new TypeToken<List<EquipMaterial>>() {}.getType());
                equipGrow.setEquipMaterialList(list);
            }

            if(equipGrow.getEquipMaterialList() == null){
                equipGrow.setEquipMaterialList(new ArrayList<>());
            }
        }
        return ResultMsg.success(equipGrowList);
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
