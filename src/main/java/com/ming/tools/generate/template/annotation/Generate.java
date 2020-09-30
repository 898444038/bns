package com.ming.tools.generate.template.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2020/3/16 0016.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Generate {

    /**
     * 代码生成是否生效
     * @return
     */
    boolean isEffective() default true;

    /**
     * 是否覆盖
     * @return
     */
    boolean isCover() default false;

    /**
     * 是否打印生成文件的内容
     * @return
     */
    boolean isLog() default false;

    /**
     * 生成基础路径（包路径下）
     * @return
     */
    String baseUrl() default "";

    /**
     * 生成文件描述
     * @return
     */
    String desc() default "";

    /**
     * 表前缀
     * @return
     */
    String tablePrefix() default "";

    /**
     * 表名
     * @return
     */
    String tableName() default "";

    /**
     * 请求类路径
     * @return
     */
    String classMapping() default "";

    /**
     * 模块名
     * @return
     */
    String moduleName() default "";

    //父包名
    String parentPackage() default "";
}
