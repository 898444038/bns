package com.ming.tools.bind.core;


import com.ming.tools.bind.dao.BaseDaoImpl;
import com.sun.org.apache.xml.internal.utils.ObjectPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * borrowObject()	从池中借对象
 * returnObject()	还回池中
 * invalidateObject()	失效一个对象
 * addObject()	池中增加一个对象
 * clear()	清空对象池
 * close()	关闭对象池
 * getNumIdle()	获得空闲对象数量
 * getNumActive()	获得被借出对象数量
 */
public class BindUtils {

    private volatile static BindUtils instance = null;

    private BindUtils(){}

    public static BindUtils getInstance(){
        if (instance==null){
            synchronized (BindUtils.class){
                if (instance==null){
                    instance = new BindUtils();
                }
            }
        }
        return instance;
    }

    private List<BindObject> list = new ArrayList<BindObject>();
    private BaseDaoImpl dao = new BaseDaoImpl();

    public List<BindObject> getAll(){
        return list;
    }

    //绑定
    public void binding(Object obj){
        Long key = ObjectUtils.getKey(obj);
        if(key == null){//增
            key = dao.add(obj);
        }
        for (BindObject bo : list){
            if(bo.getId().equals(key)){
                invalidateObject(key);
                break;
            }
        }
        ObjectUtils.setId(obj,key);
        Object data = dao.select(obj);
        ObjectUtils.copyObj(data,obj);
        list.add(new BindObject(key,obj));
        System.out.println("key:"+key);
    }

    //从池中借单对象
    public <T> T borrowOneObject(Long key){
        change();
        for (BindObject bo : list){
            if(bo.getId().equals(key) && bo.getStatus() == 0){
                //bo.setPrev(bo.getObj());
                //T t = (T)ObjectUtils.copyObj(bo.getObj());
                return (T)bo.getObj();
            }
        }
        return null;
    }
    //从池中借多对象
    public void borrowListObject(){

    }

    //失效一个对象
    public void invalidateObject(Long key){
        Iterator<BindObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            BindObject bo = iterator.next();
            if (bo.getId().equals(key)) {
                iterator.remove();//使用迭代器的删除方法删除
            }
        }
    }
    //清空对象池
    public void clear(){
        list.clear();
    }

    public void change(){
        //List<BindObject> collect = list.stream().filter(bindObject -> bindObject.getStatus().equals(0)).collect(Collectors.toList());
        for (BindObject bo : list){
            if(bo.getStatus()!=0){
                continue;
            }
            Map<String, Map<String,Object>> resultMap = ClassCompareUtil.compareFields(bo.getPrev(),bo.getObj());
            int size=resultMap.size();
            if(size>0) {
                bo.setStatus(1);
                System.out.println();
                System.out.println(bo.getPrev().getClass()+" 属性值有变化,变化结果如下：");
                Iterator<String> it = resultMap.keySet().iterator();
                while(it.hasNext()) {
                    String key=it.next();
                    System.out.println("  "+key+" : "+resultMap.get(key).get("oldValue")+" ==> "+resultMap.get(key).get("newValue"));
                }
                //同步数据库
                dao.update(bo.getObj());
                bo.setStatus(0);
                bo.setPrev(ObjectUtils.copyObj(bo.getObj()));
            }else {
                System.out.println(bo.getPrev().getClass()+" 属性值无变化！");
            }
        }
    }
}
