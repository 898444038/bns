package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.vo.EquipTypeVo;
import com.ming.bns.admin.entity.EquipType;
import com.ming.bns.admin.service.EquipTypeService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 装备类型
 * @author: Administrator
 * @date: 2020-08-03
 */
@RestController
@RequestMapping("/bns/equip/type")
public class EquipTypeController {

    @Autowired
    private EquipTypeService equipTypeService;

    @Log("EquipType")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(EquipTypeVo equipTypeVo){
        Pagination<EquipType> pagination = equipTypeService.selectPage(equipTypeVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipType")
    @GetMapping("/selectList")
    public ResultMsg selectList(EquipTypeVo equipTypeVo){
        return ResultMsg.success(equipTypeService.selectList(equipTypeVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipType")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(EquipTypeVo equipTypeVo){
        return ResultMsg.success(equipTypeService.selectOne(equipTypeVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipType")
    @PostMapping("/insert")
    public ResultMsg insert(EquipType equipType){
        if(equipType == null){
            return ResultMsg.failed();
        }
        int i = equipTypeService.insert(equipType);
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
    @Log("EquipType")
    @PostMapping("/update")
    public ResultMsg update(EquipType equipType){
        if(equipType == null || equipType.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipTypeService.update(equipType);
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
    @Log("EquipType")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipTypeService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
