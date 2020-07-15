package com.ming.tools.generate.template.enums;

/**
 * Created by Administrator on 2019/9/5 0005.
 */
public enum DescType {
    CLASS(""),
    SELECT_LIST("查询列表"),
    SELECT_ONE("查询详情"),
    INSERT("新增"),
    INSERTBATCH("批量新增"),
    UPDATE("根据id更新"),
    DELETE("根据id删除")
    ;

    private String name;

    DescType(){}
    DescType(String name){this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
