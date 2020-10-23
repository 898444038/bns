package com.ming.bns.admin.controller.bns;

import com.ming.bns.admin.vo.bns.LuckRuleVo;
import com.ming.bns.admin.service.bns.LuckRuleService;
import com.ming.bns.admin.entity.bns.LuckRule;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 抽奖规则表
 * @author: Administrator
 * @date: 2020-10-23
 */
@RestController
@RequestMapping("/bns/luck/rule")
public class LuckRuleController {

    @Autowired
    private LuckRuleService luckRuleService;

    @Log("bns.LuckRule")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(LuckRuleVo luckRuleVo){
        Pagination<LuckRule> pagination = luckRuleService.selectPage(luckRuleVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckRule")
    @GetMapping("/selectList")
    public ResultMsg selectList(LuckRuleVo luckRuleVo){
        return ResultMsg.success(luckRuleService.selectList(luckRuleVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckRule")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(LuckRuleVo luckRuleVo){
        return ResultMsg.success(luckRuleService.selectOne(luckRuleVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Log("bns.LuckRule")
    @PostMapping("/insert")
    public ResultMsg insert(LuckRule luckRule){
        if(luckRule == null){
            return ResultMsg.failed();
        }
        int i = luckRuleService.insert(luckRule);
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
    @Log("bns.LuckRule")
    @PostMapping("/update")
    public ResultMsg update(LuckRule luckRule){
        if(luckRule == null || luckRule.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = luckRuleService.update(luckRule);
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
    @Log("bns.LuckRule")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = luckRuleService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
