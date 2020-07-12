package com.ming.bns.admin.controller;

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
    @PostMapping("/auction")
    public ResultMsg auction(Integer count,String price){
        if(StringUtils.isBlank(price)){
            return ResultMsg.failed("请输入材料单价！");
        }
        Map<String,Object> data = AuctionUtil.auction(count,new BigDecimal(price));
        return ResultMsg.success(data);
    }

    /**
     * 逃税计算
     * @param count
     * @param price
     * @return
     */
    @PostMapping("/taxEvasion")
    public ResultMsg taxEvasion(Integer count,String price){
        if(StringUtils.isBlank(price)){
            return ResultMsg.failed("请输入材料单价！");
        }
        Map<String,Object> data = AuctionUtil.taxEvasion(count,new BigDecimal(price),new BigDecimal("0.00"));
        return ResultMsg.success(data);
    }
}
