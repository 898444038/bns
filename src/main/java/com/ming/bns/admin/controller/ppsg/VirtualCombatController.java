package com.ming.bns.admin.controller.ppsg;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.entity.ppsg.Level;
import com.ming.bns.admin.service.ppsg.LevelService;
import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.ppsg.LevelVo;
import com.ming.bns.admin.vo.ppsg.VirtualCombatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author: Administrator
 * @date: 2020-09-30
 */
@RestController
@RequestMapping("/ppsg/virtualCombat")
public class VirtualCombatController {

    @Log("ppsg.virtualCombat")
	@GetMapping("/calculate")
    public ResultMsg calculate(VirtualCombatVo combatVo){



        return ResultMsg.success();
    }


    @GetMapping("/add")
    public ResultMsg add(){



        return ResultMsg.success();
    }
}
