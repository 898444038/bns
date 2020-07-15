package com.ming.tools.generate.template.core;

import java.util.List;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class GenerateInfo {

    private String userName;
    private String tableName;
    private String moduleName;
    private String desc;
    private Class cla;
    private String classMapping;

    private String className;
    private String lowerClassName;
    //是否生成
    private Boolean generateVo = false;
    private Boolean generateController = false;
    private Boolean generateService = false;
    private Boolean generateServiceImpl = false;
    private Boolean generateMapper = false;
    private Boolean generateMapperXml = false;
    private Boolean generateSql = false;

    //是否覆盖
    private Boolean coverVo = false;
    private Boolean coverController = false;
    private Boolean coverService = false;
    private Boolean coverServiceImpl = false;
    private Boolean coverMapper = false;
    private Boolean coverMapperXml = false;
    private Boolean coverSql = false;

    //是否打印日志
    private Boolean isLog = false;

    private String basePackage;
    private String baseUrl;

    private String voSrcPath;//com.*.vo
    private String controllerSrcPath;
    private String serviceSrcPath;
    private String serviceImplSrcPath;
    private String mapperSrcPath;
    private String mapperXmlSrcPath;
    private String sqlSrcPath;

    private String voSuffix;
    private String controllerSuffix;
    private String serviceSuffix;
    private String serviceImplSuffix;
    private String mapperSuffix;
    private String mapperXmlSuffix;
    private String sqlSuffix;

    private String controllerName;
    private String controllerLowerName;

    private String serviceName;
    private String serviceLowerName;

    private String serviceImplName;
    private String serviceImplLowerName;

    private String mapperName;
    private String mapperLowerName;

    private String voName;
    private String voLowerName;

    private List<FieldColumn> fieldColumnList;

    public GenerateInfo() {
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Boolean getIsLog() {
        return isLog;
    }

    public void setIsLog(Boolean isLog) {
        this.isLog = isLog;
    }

    public Boolean getCoverVo() {
        return coverVo;
    }

    public void setCoverVo(Boolean coverVo) {
        this.coverVo = coverVo;
    }

    public Boolean getCoverController() {
        return coverController;
    }

    public void setCoverController(Boolean coverController) {
        this.coverController = coverController;
    }

    public Boolean getCoverService() {
        return coverService;
    }

    public void setCoverService(Boolean coverService) {
        this.coverService = coverService;
    }

    public Boolean getCoverServiceImpl() {
        return coverServiceImpl;
    }

    public void setCoverServiceImpl(Boolean coverServiceImpl) {
        this.coverServiceImpl = coverServiceImpl;
    }

    public Boolean getCoverMapper() {
        return coverMapper;
    }

    public void setCoverMapper(Boolean coverMapper) {
        this.coverMapper = coverMapper;
    }

    public Boolean getCoverMapperXml() {
        return coverMapperXml;
    }

    public void setCoverMapperXml(Boolean coverMapperXml) {
        this.coverMapperXml = coverMapperXml;
    }

    public Boolean getCoverSql() {
        return coverSql;
    }

    public void setCoverSql(Boolean coverSql) {
        this.coverSql = coverSql;
    }

    public String getSqlSrcPath() {
        return sqlSrcPath;
    }

    public void setSqlSrcPath(String sqlSrcPath) {
        this.sqlSrcPath = sqlSrcPath;
    }

    public String getSqlSuffix() {
        return sqlSuffix;
    }

    public void setSqlSuffix(String sqlSuffix) {
        this.sqlSuffix = sqlSuffix;
    }

    public List<FieldColumn> getFieldColumnList() {
        return fieldColumnList;
    }

    public void setFieldColumnList(List<FieldColumn> fieldColumnList) {
        this.fieldColumnList = fieldColumnList;
    }

    public String getVoSuffix() {
        return voSuffix;
    }

    public void setVoSuffix(String voSuffix) {
        this.voSuffix = voSuffix;
    }

    public String getControllerSuffix() {
        return controllerSuffix;
    }

    public void setControllerSuffix(String controllerSuffix) {
        this.controllerSuffix = controllerSuffix;
    }

    public String getServiceSuffix() {
        return serviceSuffix;
    }

    public void setServiceSuffix(String serviceSuffix) {
        this.serviceSuffix = serviceSuffix;
    }

    public String getServiceImplSuffix() {
        return serviceImplSuffix;
    }

    public void setServiceImplSuffix(String serviceImplSuffix) {
        this.serviceImplSuffix = serviceImplSuffix;
    }

    public String getMapperSuffix() {
        return mapperSuffix;
    }

    public void setMapperSuffix(String mapperSuffix) {
        this.mapperSuffix = mapperSuffix;
    }

    public String getMapperXmlSuffix() {
        return mapperXmlSuffix;
    }

    public void setMapperXmlSuffix(String mapperXmlSuffix) {
        this.mapperXmlSuffix = mapperXmlSuffix;
    }

    public String getVoSrcPath() {
        return voSrcPath;
    }

    public void setVoSrcPath(String voSrcPath) {
        this.voSrcPath = voSrcPath;
    }

    public String getControllerSrcPath() {
        return controllerSrcPath;
    }

    public void setControllerSrcPath(String controllerSrcPath) {
        this.controllerSrcPath = controllerSrcPath;
    }

    public String getServiceSrcPath() {
        return serviceSrcPath;
    }

    public void setServiceSrcPath(String serviceSrcPath) {
        this.serviceSrcPath = serviceSrcPath;
    }

    public String getServiceImplSrcPath() {
        return serviceImplSrcPath;
    }

    public void setServiceImplSrcPath(String serviceImplSrcPath) {
        this.serviceImplSrcPath = serviceImplSrcPath;
    }

    public String getMapperSrcPath() {
        return mapperSrcPath;
    }

    public void setMapperSrcPath(String mapperSrcPath) {
        this.mapperSrcPath = mapperSrcPath;
    }

    public String getMapperXmlSrcPath() {
        return mapperXmlSrcPath;
    }

    public void setMapperXmlSrcPath(String mapperXmlSrcPath) {
        this.mapperXmlSrcPath = mapperXmlSrcPath;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getControllerLowerName() {
        return controllerLowerName;
    }

    public void setControllerLowerName(String controllerLowerName) {
        this.controllerLowerName = controllerLowerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceLowerName() {
        return serviceLowerName;
    }

    public void setServiceLowerName(String serviceLowerName) {
        this.serviceLowerName = serviceLowerName;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
    }

    public String getServiceImplLowerName() {
        return serviceImplLowerName;
    }

    public void setServiceImplLowerName(String serviceImplLowerName) {
        this.serviceImplLowerName = serviceImplLowerName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getMapperLowerName() {
        return mapperLowerName;
    }

    public void setMapperLowerName(String mapperLowerName) {
        this.mapperLowerName = mapperLowerName;
    }

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }

    public String getVoLowerName() {
        return voLowerName;
    }

    public void setVoLowerName(String voLowerName) {
        this.voLowerName = voLowerName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLowerClassName() {
        return lowerClassName;
    }

    public void setLowerClassName(String lowerClassName) {
        this.lowerClassName = lowerClassName;
    }

    public String getClassMapping() {
        return classMapping;
    }

    public void setClassMapping(String classMapping) {
        this.classMapping = classMapping;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class getCla() {
        return cla;
    }

    public void setCla(Class cla) {
        this.cla = cla;
    }

    public Boolean getGenerateVo() {
        return generateVo;
    }

    public void setGenerateVo(Boolean generateVo) {
        this.generateVo = generateVo;
    }

    public Boolean getGenerateController() {
        return generateController;
    }

    public void setGenerateController(Boolean generateController) {
        this.generateController = generateController;
    }

    public Boolean getGenerateService() {
        return generateService;
    }

    public void setGenerateService(Boolean generateService) {
        this.generateService = generateService;
    }

    public Boolean getGenerateServiceImpl() {
        return generateServiceImpl;
    }

    public void setGenerateServiceImpl(Boolean generateServiceImpl) {
        this.generateServiceImpl = generateServiceImpl;
    }

    public Boolean getGenerateMapper() {
        return generateMapper;
    }

    public void setGenerateMapper(Boolean generateMapper) {
        this.generateMapper = generateMapper;
    }

    public Boolean getGenerateMapperXml() {
        return generateMapperXml;
    }

    public void setGenerateMapperXml(Boolean generateMapperXml) {
        this.generateMapperXml = generateMapperXml;
    }

    public Boolean getGenerateSql() {
        return generateSql;
    }

    public void setGenerateSql(Boolean generateSql) {
        this.generateSql = generateSql;
    }
}
