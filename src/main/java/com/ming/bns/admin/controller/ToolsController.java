package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.aspect.statistics.VisitStatistics;
import com.ming.bns.admin.entity.TaskChallenge;
import com.ming.bns.admin.entity.TaskTable;
import com.ming.bns.admin.service.TaskChallengeService;
import com.ming.bns.admin.service.TaskTableService;
import com.ming.bns.admin.utils.count.AuctionUtil;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.utils.Tools;
import com.ming.bns.admin.utils.count.ChallengeUtil;
import com.ming.bns.admin.vo.TaskChallengeVo;
import com.ming.bns.admin.vo.TaskTableVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    @Autowired
    private TaskTableService taskTableService;
    @Autowired
    private TaskChallengeService taskChallengeService;

    /**
     * 竞拍计算
     * @param count
     * @param price
     * @return
     */
    @Log("Tools")
    @VisitStatistics(type = "auction",desc = "竞拍计算")
    @PostMapping("/auction")
    public ResultMsg auction(Integer count,String price,Integer fyfCount,String fyfPrice){
        if(StringUtils.isBlank(price)){
            return ResultMsg.failed("请输入材料单价！");
        }
        Map<String,Object> data = AuctionUtil.auction(count,new BigDecimal(price),fyfCount,new BigDecimal(fyfPrice));
        return ResultMsg.success(data);
    }

    /**
     * 逃税计算
     * @param count
     * @param price
     * @return
     */
    @Log("Tools")
    @VisitStatistics(type = "taxEvasion",desc = "逃税计算")
    @PostMapping("/taxEvasion")
    public ResultMsg taxEvasion(Integer count,String price,Integer fyfCount,String fyfPrice){
        if(StringUtils.isBlank(price)){
            return ResultMsg.failed("请输入材料单价！");
        }
        //日交易
        BigDecimal day = new BigDecimal(count).multiply(new BigDecimal(price));
        Map<String,Object> data = AuctionUtil.taxEvasion(count,new BigDecimal(price),fyfCount,new BigDecimal(fyfPrice),day);
        return ResultMsg.success(data);
    }


    @Log("Tools")
    @VisitStatistics(type = "countChallenge",desc = "侠义车计算")
    @PostMapping("/countChallenge")
    public ResultMsg countChallenge(TaskChallengeVo vo){
        List<TaskChallenge> list = taskChallengeService.selectList(vo);

        String week = Tools.getWeek();
        TaskTableVo taskTableVo = new TaskTableVo();
        taskTableVo.setWeekName(week);
        List<TaskTable> tableList = taskTableService.selectList(taskTableVo);
        tableList = tableList.stream().filter(t->week.equals(t.getWeekName())).collect(Collectors.toList());

        List<Map<String,Object>> result = ChallengeUtil.handle(vo,list,tableList);
        return ResultMsg.success(result);
    }
}
