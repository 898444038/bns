package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 材料
 */
@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "材料",tablePrefix = "bns",parentPackage = "bns")
public class Material {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("材料名称")
    private String name;

    @Column
    @Comment("材料图片")
    private String image;

    @Column
    @Comment("材料价格")
    private BigDecimal price;

    @Column
    @Comment("创建时间")
    private Date createTime;

    @Column
    @Comment("删除标识【0：未删除，1：已删除】")
    private Boolean delFlag;

    @Column
    @Comment("材料类型【0：材料 1：装备】")
    private Integer type;

    @Column
    @Comment("封印符数量")
    private Integer num;

    public Material() {
    }

    public Material(String name, BigDecimal price, Integer num) {
        this.name = name;
        this.price = price;
        this.num = num;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", delFlag=" + delFlag +
                ", type=" + type +
                ", num=" + num +
                '}';
    }
}
