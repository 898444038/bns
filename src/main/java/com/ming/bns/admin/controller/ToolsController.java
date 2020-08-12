package com.ming.bns.admin.controller;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.aspect.statistics.VisitStatistics;
import com.ming.bns.admin.utils.AuctionUtil;
import com.ming.bns.admin.utils.ResultMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/tools")
public class ToolsController {

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
}
