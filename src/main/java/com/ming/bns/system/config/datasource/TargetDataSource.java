package com.ming.bns.system.config.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源切换方法注解
 * 我们切换数据源时，一般都是在调用mapper接口的方法前实现，
 * 所以我们定义一个方法注解，当AOP检测到方法上有该注解时，
 * 根据注解中value对应的名称进行切换
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDataSource {
    String value();//此处接收的是数据源的名称
}
