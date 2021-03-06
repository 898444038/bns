package com.ming.bns.admin.controller.bns;

import com.ming.bns.admin.entity.bns.Equip;
import com.ming.bns.admin.vo.bns.EquipVo;
import com.ming.bns.admin.service.bns.EquipService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 装备
 * @author: Administrator
 * @date: 2020-11-11
 */
@RestController
@RequestMapping("/bns/equip")
public class EquipController {

    @Autowired
    private EquipService equipService;

    @Log("bns.Equip")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(EquipVo equipVo){
        Pagination<Equip> pagination = equipService.selectPage(equipVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.Equip")
    @GetMapping("/selectList")
    public ResultMsg selectList(EquipVo equipVo){
        return ResultMsg.success(equipService.selectList(equipVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.Equip")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(EquipVo equipVo){
        return ResultMsg.success(equipService.selectOne(equipVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.Equip")
    @PostMapping("/insert")
    public ResultMsg insert(Equip equip){
        if(equip == null){
            return ResultMsg.failed();
        }
        int i = equipService.insert(equip);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.Equip")
    @PostMapping("/update")
    public ResultMsg update(Equip equip){
        if(equip == null || equip.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipService.update(equip);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-11-11
	 */
    @Log("bns.Equip")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = equipService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
