package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.service.EquipMaterialService;
import com.ming.bns.admin.vo.EquipMaterialVo;
import com.ming.bns.admin.entity.EquipMaterial;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 装备材料
 * @author: Administrator
 * @date: 2020-08-03
 */
@RestController
@RequestMapping("/bns/equip/material")
public class EquipMaterialController {

    @Autowired
    private EquipMaterialService equipMaterialService;

    @Log("EquipMaterial")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(EquipMaterialVo equipMaterialVo){
        Pagination<EquipMaterial> pagination = equipMaterialService.selectPage(equipMaterialVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipMaterial")
    @GetMapping("/selectList")
    public ResultMsg selectList(EquipMaterialVo equipMaterialVo){
        return ResultMsg.success(equipMaterialService.selectList(equipMaterialVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipMaterial")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(EquipMaterialVo equipMaterialVo){
        return ResultMsg.success(equipMaterialService.selectOne(equipMaterialVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-03
	 */
    @Log("EquipMaterial")
    @PostMapping("/insert")
    public ResultMsg insert(EquipMaterial equipMaterial){
        if(equipMaterial == null){
            return ResultMsg.failed();
        }
        int i = equipMaterialService.insert(equipMaterial);
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
    @Log("EquipMaterial")
    @PostMapping("/update")
    public ResultMsg update(EquipMaterial equipMaterial){
        if(equipMaterial == null || equipMaterial.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipMaterialService.update(equipMaterial);
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
    @Log("EquipMaterial")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipMaterialService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
