package com.ming.bns.admin.entity.bns;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.database.Text;

import java.io.Serializable;
import java.util.Date;

@Generate(isEffective = true,isCover = false,desc = "日志",tablePrefix = "s",parentPackage = "bns")
public class SystemLog implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("登录IP")
    private String loginIp;

    @Column
    @Comment("访问路径")
    private String mapping;

    @Column
    @Comment("访问方法")
    private String method;

    @Column
    @Comment("方法参数")
    private String args;

    @Column
    @Text
    @Comment("返回结果")
    private String result;

    @Column
    @Comment("日志类型")
    private String type;

    @Column
    @Comment("创建时间")
    private Date createTime;

    @Column
    @Comment("执行时间")
    private String executeTime;

    public SystemLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }
}
