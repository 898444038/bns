package com.ming.tools.generate.template.core;

import com.ming.tools.generate.template.utils.PropertyUtil;

import java.util.Map;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class GenerateConfig {

    private static Map<String,String> map = PropertyUtil.getProperty("/generate.properties");

    private static final String voTemplateKey = "generate.vo.template.path";
    private static final String controllerTemplateKey = "generate.controller.template.path";
    private static final String serviceTemplateKey = "generate.service.template.path";
    private static final String serviceImplTemplateKey = "generate.service.impl.template.path";
    private static final String mapperTemplateKey = "generate.mapper.template.path";
    private static final String mapperXmlTemplateKey = "generate.mapper.xml.template.path";
    private static final String sqlTemplateKey = "generate.sql.template.path";

    public static String getVoTemplatePath(){return map.get(voTemplateKey);}
    public static String getControllerTemplatePath(){return map.get(controllerTemplateKey);}
    public static String getServiceTemplatePath(){return map.get(serviceTemplateKey);}
    public static String getServiceImplTemplatePath(){return map.get(serviceImplTemplateKey);}
    public static String getMapperTemplatePath(){return map.get(mapperTemplateKey);}
    public static String getMapperXmlTemplatePath(){return map.get(mapperXmlTemplateKey);}
    public static String getSqlTemplatePath(){return map.get(sqlTemplateKey);}


    private static final String voSrcKey = "generate.vo.src.path";
    private static final String controllerSrcKey = "generate.controller.src.path";
    private static final String serviceSrcKey = "generate.service.src.path";
    private static final String serviceImplSrcKey = "generate.service.impl.src.path";
    private static final String mapperSrcKey = "generate.mapper.src.path";
    private static final String mapperXmlSrcKey = "generate.mapper.xml.src.path";
    private static final String sqlSrcKey = "generate.sql.src.path";

    public static String getVoSrcPath(){return map.get(voSrcKey);}
    public static String getControllerSrcPath(){return map.get(controllerSrcKey);}
    public static String getServiceSrcPath(){return map.get(serviceSrcKey);}
    public static String getServiceImplSrcPath(){return map.get(serviceImplSrcKey);}
    public static String getMapperSrcPath(){return map.get(mapperSrcKey);}
    public static String getMapperXmlSrcPath(){return map.get(mapperXmlSrcKey);}
    public static String getSqlSrcPath(){return map.get(sqlSrcKey);}
}
