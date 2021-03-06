package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

/**
 * 侠义
 * 1-5      10000、10400、10900、11600、12500
 * 6-10     13600、14900、16400、18100、20000
 * 11-15    22100、24400、26900、29600、32500
 * 16-20    35600、38900、42400、46100、50000
 * 21-25    54100、58400、62900、67600、72500
 * 26-30    77600、82900、88400、94100、100000
 * 31-35    106100、112400、118900、125600、132500
 * 36-40    139600、146900、154400、162100、170000
 * 41-45    178100、186400、194900、203600、212500
 * 46-50    221600、230900、240400、250100、260000
 * 51-55    270100、280400、290900、301600、312500
 * 56-60    323600、334900、346400、358100、370000
 * 61-65    382100、394400、406900、419600、432500
 * 66-70    445600、458900、472400、486100、500000
 * 71-75    514100、528400、542900、557600、572500
 * 76-80    587600、602900、618400、634100、650000
 * 81-85    666100、682400、698900、715600、732500
 * 86-90    749600、766900、784400、802100、820000
 * 91-95    838100、856400、874900、893600、912500
 * 96-100   931600、950900、970400、990100、1010000
 * 101-105  1030100、1050400、1070900、1091600、1112500
 * 106-110  1133600、1154900、1176400、1198100、1220000
 * 111-115  1242100、1264400、1286900、1309600、1332500
 * 116-120  1355600、1378900、1402400、1426100、1450000
 *
 */
@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "侠义团等级",tablePrefix = "bns",parentPackage = "bns")
public class Chivalrous implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("侠义团等级")
    private Integer chivalrous;

    @Column
    @Comment("经验")
    private Long exp;

    @Column
    @Comment("备注")
    private String remark;

    public Chivalrous() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChivalrous() {
        return chivalrous;
    }

    public void setChivalrous(Integer chivalrous) {
        this.chivalrous = chivalrous;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
