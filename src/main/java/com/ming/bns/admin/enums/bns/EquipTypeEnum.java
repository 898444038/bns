package com.ming.bns.admin.enums.bns;

/**
 * 装备类型
 */
public enum EquipTypeEnum {

    wu_qi(1,"武器"),
    yuan_qi_shi(2,"元气石"),
    zhen_qi_shi(3,"真气石"),

    xiang_lian(4,"项链"),
    er_huan(5,"耳环"),
    jie_zhi(6,"戒指"),

    shou_zhou(7,"手镯"),
    yao_dai(8,"腰带"),
    shou_tao(9,"手套"),

    hun(10,"魂"),
    ling(11,"灵"),
    shou_hu_shi(12,"守护石"),
    xing(13,"星"),

    bao_shi(14,"宝石"),

    ;


    private Integer code;
    private String name;

    EquipTypeEnum(Integer code,String name) {
        this.code = code;
        this.name = name;
    }


}
