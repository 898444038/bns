package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.service.EquipGrowService;
import com.ming.bns.admin.entity.EquipGrow;
import com.ming.bns.admin.vo.EquipGrowVo;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
