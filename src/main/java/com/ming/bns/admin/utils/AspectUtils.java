package com.ming.bns.admin.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ming.bns.admin.entity.Star;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AspectUtils {

    private volatile static AspectUtils instance = null;

    private AspectUtils(){}
    public static AspectUtils getInstance(){
        if(instance==null){
            synchronized (AspectUtils.class){
                if(instance==null){
                    instance = new AspectUtils();
                }
            }
        }
        return instance;
    }

    private static final String[] types = {
            "java.lang.Integer","int",
            "java.lang.Double","double",
            "java.lang.Float","float",
            "java.lang.Long","long",
            "java.lang.Short","short",
            "java.lang.Byte","byte",
            "java.lang.Boolean","boolean",
            "java.lang.Character","char",
            "java.lang.String",
    };

    public String bulidParams(ProceedingJoinPoint joinPoint)throws Exception{
        String[] paramNames = getParamNames(joinPoint);
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < args.length; k++) {
            boolean clazzFlag = true;
            Object arg = args[k];
            if(arg==null){
                continue;
            }
            sb.append(paramNames[k]+":{");
            String typeName = arg.getClass().getTypeName();
            for (String type: types){
                if(type.equals(typeName)){
                    clazzFlag = false;
                    sb.append("=").append(argValue(arg)).append(",");
                }
            }
            if (clazzFlag){
                sb.append(getFieldValue(arg));
            }
            sb.append("},");
        }
        return sb.toString();
    }

    private String[] getParamNames(ProceedingJoinPoint joinPoint){
        return ((MethodSignature)joinPoint.getSignature()).getParameterNames();
    }

    public String argValue(Object arg){
        //String argStr = JSON.toJSONString(arg);
        //return argStr.length()>256?argStr.subSequence(0,256)+"...":argStr;
        //return argStr;

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(arg);
    }

    public String getFieldValue(Object obj) throws Exception{
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field field :fields) {
            field.setAccessible(true);
            try{
                field.get(null);
            }catch (NullPointerException e){
                Object objArg = field.get(obj);
                if(objArg==null){
                    continue;
                }
                for (String type:types) {
                    if(field.getType().getName().equals(type)){
                        sb.append(field.getName()).append(argValue(objArg)).append(",");
                    }
                }
            }
        }
        return sb.toString();
    }

    private static final String unknown = "unknown";
    private static final String xForwardedFor = "x-forwarded-for";
    private static final String proxyClientIp = "Proxy-Client-IP";
    private static final String wlProxyClientIp = "WL-Proxy-Client-IP";
    private static final String httpClientIp = "HTTP-CLIENT-IP";
    private static final String httpXForwardedFor = "HTTP_X_FORWARDED_FOR";
    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader(xForwardedFor);
        if(ip==null || ip.length()==0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader(proxyClientIp);
        }
        if(ip==null || ip.length()==0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader(wlProxyClientIp);
        }
        if(ip==null || ip.length()==0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader(httpClientIp);
        }
        if(ip==null || ip.length()==0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader(httpXForwardedFor);
        }
        if(ip==null || ip.length()==0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getMapping(Class clazz, Method method){
        String classMapping = "";
        String methodMapping = "";
        if(clazz.isAnnotationPresent(RequestMapping.class)){
            RequestMapping requestMapping = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if(requestMapping!=null && requestMapping.value().length!=0){
                classMapping += requestMapping.value()[0];
            }
        }
        if(!classMapping.startsWith("/")){
            classMapping = "/"+classMapping;
        }
        if(method.isAnnotationPresent(RequestMapping.class)){
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            if(requestMapping!=null && requestMapping.value().length!=0){
                methodMapping += requestMapping.value()[0];
            }
        }else if(method.isAnnotationPresent(GetMapping.class)){
            GetMapping requestMapping = method.getAnnotation(GetMapping.class);
            if(requestMapping!=null && requestMapping.value().length!=0){
                methodMapping += requestMapping.value()[0];
            }
        }else if(method.isAnnotationPresent(PostMapping.class)){
            PostMapping requestMapping = method.getAnnotation(PostMapping.class);
            if(requestMapping!=null && requestMapping.value().length!=0){
                methodMapping += requestMapping.value()[0];
            }
        }else if(method.isAnnotationPresent(PutMapping.class)){
            PutMapping requestMapping = method.getAnnotation(PutMapping.class);
            if(requestMapping!=null && requestMapping.value().length!=0){
                methodMapping += requestMapping.value()[0];
            }
        }else if(method.isAnnotationPresent(DeleteMapping.class)){
            DeleteMapping requestMapping = method.getAnnotation(DeleteMapping.class);
            if(requestMapping!=null && requestMapping.value().length!=0){
                methodMapping += requestMapping.value()[0];
            }
        }
        if(!methodMapping.startsWith("/")){
            methodMapping = "/"+methodMapping;
        }
        return classMapping+methodMapping;
    }

    public static <T> T getClassAnnotation(Class clazz,Class annoClass){
        if(clazz.isAnnotationPresent(annoClass)){
             return (T)clazz.getAnnotation(annoClass);
        }
        return null;
    }
    public static String getMethodAnnotation(Method method){

        return null;
    }

}
