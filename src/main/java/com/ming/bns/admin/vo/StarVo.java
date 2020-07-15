package com.ming.bns.admin.vo;

import com.ming.bns.admin.entity.Star;


/**
 * 星级
 * @author: Administrator
 * @date: 2020-07-15
 */
public class StarVo extends Star {

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

