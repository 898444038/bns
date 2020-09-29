package com.ming.tools.bind.core;

public class BindObject {

    private Long id;

    private String clazz;
    //状态[0:相同、1:变化、2:、-1:失效]
    private Integer status;

    private Object obj;

    private Object prev;

    public BindObject(){}
    public BindObject(Long key, Object obj){
        this.setId(key);
        this.setObj(obj);
        this.setPrev(ObjectUtils.copyObj(obj));
        this.setStatus(0);
        this.setClazz(obj.getClass().getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getPrev() {
        return prev;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }
}
