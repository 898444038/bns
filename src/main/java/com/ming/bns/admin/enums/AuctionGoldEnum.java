package com.ming.bns.admin.enums;

/**
 * 拍卖行交易税  单笔手续费
 */
public enum  AuctionGoldEnum {

    AG_0(0,99.99,0.05),
    AG_100(100,999.99,0.06),
    AG_1000(1000,4999.99,0.07),
    AG_5000(5000,9999.99,0.09),
    AG_10000(10000,Double.MAX_VALUE,0.1),

    ;


    private double startPrice;
    private double endPrice;
    private double tax;//扣税

    AuctionGoldEnum(double startPrice, double endPrice, double tax) {
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.tax = tax;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public double getTax() {
        return tax;
    }
}
