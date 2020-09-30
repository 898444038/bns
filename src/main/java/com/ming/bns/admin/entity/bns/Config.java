package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "配置表",tablePrefix = "bns",parentPackage = "bns")
public class Config implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("编号")
    private String code;

    @Column
    @Comment("值")
    private String val;

    @Column
    @Comment("默认值")
    private String defaultVal;

    @Column
    @Comment("备注")
    private String remark;

    @Column
    @Comment("是否启用[0:未启用,1:启用]")
    private Boolean isEnable;

    public Config() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
