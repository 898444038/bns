package com.ming.bns.admin.vo;

import com.ming.bns.admin.entity.Material;


/**
 * 材料
 * @author: Administrator
 * @date: 2020-07-16
 */
public class MaterialVo extends Material {

    private Integer pageNo;

    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}

