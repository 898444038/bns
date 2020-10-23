package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.util.Date;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "抽奖项表",tablePrefix = "bns",parentPackage = "bns")
public class LuckItem {
    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("luckId")
    private Long LuckId;

    @Column
    @Comment("奖品名称")
    private String name;

    @Column
    @Comment("奖品权重")
    private Integer weight;

    @Column
    @Comment("排序")
    private Integer sort;

    @Column
    @Comment("备注")
    private String remark;

    @Column
    @Comment("创建时间")
    private Date createTime;

    public LuckItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLuckId() {
        return LuckId;
    }

    public void setLuckId(Long luckId) {
        LuckId = luckId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
