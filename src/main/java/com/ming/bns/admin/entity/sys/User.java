package com.ming.bns.admin.entity.sys;


import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "用户表",tablePrefix = "sys",parentPackage = "sys")
public class User implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("名称")
    private String username;

    @Column
    @Comment("密码")
    private String password;

    @Column
    @Comment("邮箱")
    private String email;

    @Column
    @Comment("是否启用[0:未启用,1:启用]")
    private Boolean isEnable;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
