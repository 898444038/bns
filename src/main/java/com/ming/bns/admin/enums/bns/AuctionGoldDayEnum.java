package com.ming.bns.admin.enums.bns;

/**
 * 拍卖行交易税  日交易手续费
 */
public enum  AuctionGoldDayEnum {

    AGD_0(0,499.99,0),
    AGD_500(500,999.99,0.01),
    AGD_1000(1000,1999.99,0.02),
    AGD_2000(2000,9999.99,0.03),
    AGD_10000(10000,Double.MAX_VALUE,0.1),

    ;


    private double startPrice;
    private double endPrice;
    private double tax;//扣税

    AuctionGoldDayEnum(double startPrice, double endPrice, double tax) {
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
