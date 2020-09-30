package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "装备成长",tablePrefix = "bns",parentPackage = "bns")
public class EquipGrow implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("开始段数")
    private Long startEquipId;

    @Column
    @Comment("结束段数")
    private Long endEquipId;

    @Column
    @Comment("成长方式")
    private Integer growType;

    @Column
    @Comment("成长折扣")
    private BigDecimal discount;

    @Column
    @Comment("金")
    private BigDecimal gold;

    private List<EquipMaterial> equipMaterialList;

    public EquipGrow() {
    }

    public EquipGrow(Long startEquipId, Long endEquipId) {
        this.startEquipId = startEquipId;
        this.endEquipId = endEquipId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartEquipId() {
        return startEquipId;
    }

    public void setStartEquipId(Long startEquipId) {
        this.startEquipId = startEquipId;
    }

    public Long getEndEquipId() {
        return endEquipId;
    }

    public void setEndEquipId(Long endEquipId) {
        this.endEquipId = endEquipId;
    }

    public Integer getGrowType() {
        return growType;
    }

    public void setGrowType(Integer growType) {
        this.growType = growType;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public List<EquipMaterial> getEquipMaterialList() {
        return equipMaterialList;
    }

    public void setEquipMaterialList(List<EquipMaterial> equipMaterialList) {
        this.equipMaterialList = equipMaterialList;
    }
}