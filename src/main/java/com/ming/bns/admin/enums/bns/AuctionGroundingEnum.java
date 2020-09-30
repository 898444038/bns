package com.ming.bns.admin.enums.bns;

/**
 * 拍卖行上架手续费
 */
public enum  AuctionGroundingEnum {

    AG_1(1,11,0),
    AG_11(11,50,0.01),
    AG_51(51,100,0.02),
    AG_101(101,250,0.03),
    AG_251(251,500,0.05),
    AG_501(501,1000,0.08),
    AG_1001(1001,2000,0.11),
    AG_2001(2001,5000,0.13),
    AG_5001(5001,9999,0.15),

    ;


    private int startCount;
    private int endCount;
    private double tax;//扣税

    AuctionGroundingEnum(int startCount, int endCount, double tax) {
        this.startCount = startCount;
        this.endCount = endCount;
        this.tax = tax;
    }
}
