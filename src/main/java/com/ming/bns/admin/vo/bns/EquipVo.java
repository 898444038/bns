package com.ming.bns.admin.vo.bns;

import com.ming.bns.admin.entity.bns.Equip;


/**
 * 装备
 * @author: Administrator
 * @date: 2020-11-11
 */
public class EquipVo extends Equip {

    private Integer pageNo;

    private Integer pageSize;

    private Integer pageStart;

    private String pageSort;

    public EquipVo() {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo == null) {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
            this.pageStart = (pageNo - 1) * this.pageSize;
        } else {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public String getPageSort() {
        return pageSort;
    }

    public void setPageSort(String pageSort) {
        this.pageSort = pageSort;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
}

