package com.ming.tools.bind.core;

import com.ming.tools.bind.anno.BindKey;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectUtils {

    public static Long getKey(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields){
                if(field.isAnnotationPresent(BindKey.class)){
                    field.setAccessible(true);
                    Object resultValue = field.get(obj);
                    return (Long)resultValue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Object copyObj(Object obj) {
        try {
            Class<?> classType = obj.getClass();//获取class对象
            Object objRes = classType.newInstance();//构建目标对象
            for (Field field : classType.getDeclaredFields()) {
                field.setAccessible(true);//设置可访问权限
                Object value = field.get(obj);//利用get方法取obj的值
                field.set(objRes, value);
            }
            return objRes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    public static Object copyObj(Object source,Object target) {
        try {
            Class<?> classType = source.getClass();//获取class对象
            for (Field field : classType.getDeclaredFields()) {
                field.setAccessible(true);//设置可访问权限
                Object value = field.get(source);//利用get方法取obj的值
                field.set(target, value);
            }
            return target;
        }catch (Exception e){
            e.printStackTrace();
        }
        return source;
    }

    public static void setId(Object obj,Long id){
        Method method = null;
        try {
            method = obj.getClass().getMethod("setId", Long.class);
            method.invoke(obj, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
