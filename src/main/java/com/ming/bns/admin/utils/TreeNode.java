package com.ming.bns.admin.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode{

    private int id;

    private int parentId;

    private String name;

    private List<TreeNode> children;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<TreeNode> getChildren() {
        return children;
    }
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{id:"+id+",name:"+name+",parentid:"+parentId+",children:["+printChildren()+"]}";
    }

    private String printChildren(){
        String childrenStr = "";
        for(TreeNode t : children){
            childrenStr += t.toString();
        }
        return childrenStr;
    }
}