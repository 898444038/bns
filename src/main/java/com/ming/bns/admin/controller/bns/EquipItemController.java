package com.ming.bns.admin.controller.bns;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ming.bns.admin.service.bns.EquipGrowService;
import com.ming.bns.admin.service.bns.EquipItemService;
import com.ming.bns.admin.entity.bns.EquipItem;
import com.ming.bns.admin.vo.bns.EquipItemVo;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 装备项
 * @author: Administrator
 * @date: 2020-11-11
 */
@RestController
@RequestMapping("/bns/equip/item")
public class EquipItemController {

    @Autowired
    private EquipItemService equipItemService;
    @Autowired
    private EquipGrowService equipGrowService;

    @Log("bns.EquipItem")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(EquipItemVo equipItemVo){
        Pagination<EquipItem> pagination = equipItemService.selectPage(equipItemVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.EquipItem")
    @GetMapping("/selectList")
    public ResultMsg selectList(EquipItemVo equipItemVo){
        return ResultMsg.success(equipItemService.selectList(equipItemVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.EquipItem")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(EquipItemVo equipItemVo){
        return ResultMsg.success(equipItemService.selectOne(equipItemVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.EquipItem")
    @PostMapping("/insert")
    public ResultMsg insert(EquipItem equipItem){
        if(equipItem == null){
            return ResultMsg.failed();
        }
        int i = equipItemService.insert(equipItem);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

    @Log("bns.EquipItem")
    @PostMapping("/insertList")
    public ResultMsg insertList(EquipItemVo equipItemVo){
        Gson gson = new Gson();
        List<EquipItem> list = gson.fromJson(equipItemVo.getItems(), new TypeToken<List<EquipItem>>() {}.getType());
        if(list == null || list.size() == 0){
            return ResultMsg.failed();
        }
        try {
            EquipItemVo vo = new EquipItemVo();
            vo.setEquipId(equipItemVo.getEquipId());
            Long parentId = 0L;
            for (EquipItem item : list){
                if(item.getId() == null){
                    EquipItemVo itemVo = new EquipItemVo();
                    itemVo.setEquipId(item.getEquipId());
                    itemVo.setSort(item.getSort());
                    EquipItem equipItem = equipItemService.selectOne(itemVo);
                    /*for (EquipItem equipItem : equipItemList){
                        if(item.getEquipId().equals(equipItem.getEquipId()) && item.getSort().equals(equipItem.getSort())){
                            break;
                        }
                    }*/
                    item.setType(equipItemVo.getType());
                    item.setParentId(parentId);
                    if(equipItem == null){
                        equipItemService.insert(item);
                    }else{
                        item.setId(equipItem.getId());
                        item.setChildren(equipItem.getChildren());
                        equipItemService.update(item);
                    }
                    parentId = item.getId();
                }else{
                    item.setType(equipItemVo.getType());
                    parentId = item.getId();
                    equipItemService.update(item);
                }
            }
            equipGrowService.refresh(equipItemVo);
            return ResultMsg.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.EquipItem")
    @PostMapping("/update")
    public ResultMsg update(EquipItem equipItem){
        if(equipItem == null || equipItem.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipItemService.update(equipItem);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

    @Log("bns.EquipItem")
    @PostMapping("/updateList")
    public ResultMsg updateList(EquipItemVo equipItemVo){
        Gson gson = new Gson();
        List<EquipItem> list = gson.fromJson(equipItemVo.getItems(), new TypeToken<List<EquipItem>>() {}.getType());
        if(list == null || list.size() == 0){
            EquipItem equipItem = new EquipItem();
            equipItem.setEquipId(equipItemVo.getEquipId());
            equipItem.setChildren("");
            equipItemService.update(equipItem);
        }else{
            for (EquipItem equipItem : list){
                equipItemService.update(equipItem);
            }
        }
        //equipGrowService.refresh(equipItemVo);
        return ResultMsg.success();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.EquipItem")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipItemService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

    @Log("bns.EquipItem")
    @PostMapping("/deleteItem")
    public ResultMsg deleteItem(EquipItemVo equipItemVo){
        int i = equipItemService.deleteItem(equipItemVo);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
