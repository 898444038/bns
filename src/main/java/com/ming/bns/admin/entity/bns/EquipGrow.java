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
    @Comment("Equip表主键")
    private Long equipId;

    @Column
    @Comment("Equip表主键")
    private Long equipId2;

    @Column
    @Comment("装备类型")
    private Integer type;

    @Column
    @Comment("开始段数")
    private Long startSort;

    @Column
    @Comment("结束段数")
    private Long endSort;

    @Column
    @Comment("成长方式")
    private Integer growType;

    @Column
    @Comment("成长折扣")
    private BigDecimal discount;

    @Column
    @Comment("金")
    private BigDecimal gold;

    @Column
    @Comment("起始项")
    private Long startItemId;

    @Column
    @Comment("目标项")
    private Long endItemId;

    private List<EquipMaterial> equipMaterialList;

    private String startItemName;
    private String endItemName;

    @Column
    @Comment("材料明细")
    private String materials;

    public EquipGrow() {}

    public EquipGrow(Long startSort, Long endSort) {
        this.startSort = startSort;
        this.endSort = endSort;
    }

    public EquipGrow(Long equipId,Long equipId2, Integer type, Long startSort, Long endSort) {
        this.equipId = equipId;
        this.equipId2 = equipId2;
        this.type = type;
        this.startSort = startSort;
        this.endSort = endSort;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getStartItemName() {
        return startItemName;
    }

    public void setStartItemName(String startItemName) {
        this.startItemName = startItemName;
    }

    public String getEndItemName() {
        return endItemName;
    }

    public void setEndItemName(String endItemName) {
        this.endItemName = endItemName;
    }

    public Long getStartItemId() {
        return startItemId;
    }

    public void setStartItemId(Long startItemId) {
        this.startItemId = startItemId;
    }

    public Long getEndItemId() {
        return endItemId;
    }

    public void setEndItemId(Long endItemId) {
        this.endItemId = endItemId;
    }

    public Long getEquipId2() {
        return equipId2;
    }

    public void setEquipId2(Long equipId2) {
        this.equipId2 = equipId2;
    }

    public Long getEquipId() {
        return equipId;
    }

    public void setEquipId(Long equipId) {
        this.equipId = equipId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartSort() {
        return startSort;
    }

    public void setStartSort(Long startSort) {
        this.startSort = startSort;
    }

    public Long getEndSort() {
        return endSort;
    }

    public void setEndSort(Long endSort) {
        this.endSort = endSort;
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

    @Override
    public String toString() {
        return "EquipGrow{" +
                "id=" + id +
                ", equipId=" + equipId +
                ", equipId2=" + equipId2 +
                ", type=" + type +
                ", startSort=" + startSort +
                ", endSort=" + endSort +
                ", startItemId=" + startItemId +
                ", endItemId=" + endItemId +
                ", equipMaterialList=" + equipMaterialList +
                '}';
    }
}