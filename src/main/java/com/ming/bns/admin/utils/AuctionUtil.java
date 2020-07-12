package com.ming.bns.admin.utils;

import com.ming.bns.admin.enums.AuctionGoldDayEnum;
import com.ming.bns.admin.enums.AuctionGoldEnum;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AuctionUtil {
    public static void main(String[] args) {
        //taxEvasion(2,new BigDecimal("12000.00"),new BigDecimal("0.00"));
        auction(5,new BigDecimal("100.00"));
    }

    /**
     * 竞拍计算
     * @param count 人数
     * @param price 单价
     */
    public static Map<String,Object> auction(Integer count, BigDecimal price){
        Map<String,Object> data = new HashMap<>();
        //逃税
        Map<String,Object> taxEvasionMap = taxEvasion(1,price,new BigDecimal("0.00"));
        BigDecimal tsdj = new BigDecimal((double) taxEvasionMap.get("tsdj")).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(tsdj);
        BigDecimal personCount = new BigDecimal(count);
        BigDecimal personCount2 = new BigDecimal(count-1);

        //平分
        BigDecimal middle = tsdj.divide(personCount, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal middleAuction = middle.multiply(personCount2).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("平分竞拍价: "+middleAuction.doubleValue()+", mine: "+middle.doubleValue()+", other: "+middle.doubleValue());
        //最低竞拍价
        BigDecimal minAuction = middle.multiply(personCount2).multiply(new BigDecimal("0.9")).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal minMine = tsdj.subtract(minAuction).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal minOther = minAuction.divide(personCount2, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("最低竞拍价: "+minAuction.doubleValue()+", mine: "+minMine.doubleValue()+", other: "+minOther.doubleValue());
        //最高竞拍价
        BigDecimal max = price.divide(personCount, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal maxAuction = max.multiply(personCount2).setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println("最高竞拍价: "+maxAuction.doubleValue()+", mine: "+max.doubleValue()+", other: "+max.doubleValue());

        Map<String,Object> midMap = new HashMap<>();
        midMap.put("auction",middleAuction.doubleValue()+"");
        midMap.put("mine",middle.doubleValue()+"");
        midMap.put("other",middle.doubleValue()+"");

        Map<String,Object> minMap = new HashMap<>();
        minMap.put("auction",minAuction.doubleValue()+"");
        minMap.put("mine",minMine.doubleValue()+"");
        minMap.put("other",minOther.doubleValue()+"");

        Map<String,Object> maxMap = new HashMap<>();
        maxMap.put("auction",maxAuction.doubleValue()+"");
        maxMap.put("mine",max.doubleValue()+"");
        maxMap.put("other",max.doubleValue()+"");

        data.put("mid",midMap);
        data.put("min",minMap);
        data.put("max",maxMap);
        return data;
    }

    /**
     * 逃税价
     * @param count 数量
     * @param price 单价
     * @param dayPrice 日交易
     */
    public static Map<String,Object> taxEvasion(Integer count, BigDecimal price, BigDecimal dayPrice){
        //单笔税
        double start = 0d;
        double end = 0d;
        AuctionGoldEnum cuur = null;
        for(AuctionGoldEnum auctionGoldEnum : AuctionGoldEnum.values()){
            start = auctionGoldEnum.getStartPrice();
            end = auctionGoldEnum.getEndPrice();
            if(price.doubleValue() >= start && price.doubleValue() <= end ){
                cuur = auctionGoldEnum;
            }
        }
        System.out.println(cuur.getStartPrice());
        System.out.println(cuur.getEndPrice());
        System.out.println(cuur.getTax());
        BigDecimal b1 = new BigDecimal("1.00");
        BigDecimal b2 = new BigDecimal(cuur.getTax());
        BigDecimal b3 = b1.subtract(b2).setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal ydj = price;
        BigDecimal yzj = new BigDecimal(count+"").multiply(price);
        BigDecimal tsdj = price.multiply(b3);
        BigDecimal tszj = new BigDecimal(count+"").multiply(tsdj);
        BigDecimal dsj = ydj.subtract(tsdj);
        BigDecimal zsj = yzj.subtract(tszj);

        //日交易税
        if(dayPrice!=null && dayPrice.intValue()!=0){
            AuctionGoldDayEnum cuurDay = null;
            for(AuctionGoldDayEnum auctionGoldDayEnum : AuctionGoldDayEnum.values()) {
                start = auctionGoldDayEnum.getStartPrice();
                end = auctionGoldDayEnum.getEndPrice();
                if(yzj.doubleValue() >= start && yzj.doubleValue() <= end ){
                    cuurDay = auctionGoldDayEnum;
                }
            }
            if(cuurDay!=null){

            }
        }


        //上架数量税

        System.out.println("数量："+count);
        System.out.println("原单价："+ydj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("原总价："+yzj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("逃税单价："+tsdj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("逃税总价："+tszj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("单税价："+dsj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("总税价："+zsj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        Map<String,Object> data = new HashMap<>();
        data.put("tsdj",tsdj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        data.put("tszj",tszj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        data.put("dsj",dsj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        data.put("zsj",zsj.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return data;
    }


}
