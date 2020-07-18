package com.ming.bns.admin.entity;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;

import java.io.Serializable;

/**
 * 星级	所需经验值
 * 1	              500,000
 * 2	              750,000
 * 3	           1,000,000
 * 4	           1,138,000
 * 5	           2,008,000
 * 6	           3,130,000
 * 7	           4,821,000
 * 8	           7,231,500
 * 9	         10,124,100
 * 10	         15,186,150
 * 11	         22,779,225
 * 12	         34,168,838
 * 13	         44,419,489
 * 14	         57,745,335
 * 15	         77,956,203
 * 16	      109,138,684
 * 17	      152,794,157
 * 18	      213,911,820
 * 19	      299,476,549
 * 20	      389,319,513
 * 21	      506,115,367
 * 22	      632,644,209
 * 23	      746,520,166
 * 24	      858,498,191
 * 25	   1,055,952,775
 * 26	   1,224,905,219
 * 27	   1,427,014,580
 * 28	   1,669,607,059
 * 29	   1,970,136,330
 * 30	   2,305,059,507
 * 31	   2,673,869,028
 * 32	   3,074,949,383
 * 33	   3,505,442,297
 * 34	   3,961,149,797
 */
@Generate(isEffective = true,isCover = false,desc = "星级",tablePrefix = "bns")
public class Star implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("星级")
    private Integer star;

    @Column
    @Comment("经验")
    private Integer exp;

    @Column
    @Comment("备注")
    private String remark;

    public Star() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", star=" + star +
                ", exp=" + exp +
                ", remark='" + remark + '\'' +
                '}';
    }
}
