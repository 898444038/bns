package com.ming.bns.admin.controller.bns;

import com.ming.bns.admin.vo.bns.LuckItemVo;
import com.ming.bns.admin.entity.bns.LuckItem;
import com.ming.bns.admin.service.bns.LuckItemService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 抽奖项表
 * @author: Administrator
 * @date: 2020-10-23
 */
@RestController
@RequestMapping("/bns/luck/item")
public class LuckItemController {

    @Autowired
    private LuckItemService luckItemService;

    @Log("bns.LuckItem")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(LuckItemVo luckItemVo){
        Pagination<LuckItem> pagination = luckItemService.selectPage(luckItemVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckItem")
    @GetMapping("/selectList")
    public ResultMsg selectList(LuckItemVo luckItemVo){
        return ResultMsg.success(luckItemService.selectList(luckItemVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckItem")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(LuckItemVo luckItemVo){
        return ResultMsg.success(luckItemService.selectOne(luckItemVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckItem")
    @PostMapping("/insert")
    public ResultMsg insert(LuckItem luckItem){
        if(luckItem == null){
            return ResultMsg.failed();
        }
        int i = luckItemService.insert(luckItem);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckItem")
    @PostMapping("/update")
    public ResultMsg update(LuckItem luckItem){
        if(luckItem == null || luckItem.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = luckItemService.update(luckItem);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckItem")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = luckItemService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
