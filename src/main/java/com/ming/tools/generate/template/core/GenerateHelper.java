package com.ming.tools.generate.template.core;

import com.ming.tools.generate.template.enums.DescType;
import com.ming.tools.generate.template.utils.GenerateString;
import com.ming.tools.generate.template.utils.GenerateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class GenerateHelper {

    public static void generateVo(GenerateInfo info) {
        if(info.getGenerateVo()){
            Map<Integer,String> map = ReadTemplateHelper.getInstance().readTxtFile(GenerateConfig.getVoTemplatePath());
            if (!map.isEmpty()) {
                handle(map, info, GenerateConfig.getVoSrcPath());
                WriteTemplateHelper.writeSrc(info.getVoSrcPath(), info.getVoSuffix(), map ,info.getCoverVo(),info);
            }
        }
    }

    public static void generateController(GenerateInfo info) {
        if(info.getGenerateController()){
            Map<Integer,String> map = ReadTemplateHelper.getInstance().readTxtFile(GenerateConfig.getControllerTemplatePath());
            if (!map.isEmpty()) {
                handle(map, info, GenerateConfig.getControllerSrcPath());
                WriteTemplateHelper.writeSrc(info.getControllerSrcPath(), info.getControllerSuffix(), map ,info.getCoverController(),info);
            }
        }
    }

    public static void generateService(GenerateInfo info) {
        if(info.getGenerateService()){
            Map<Integer,String> map = ReadTemplateHelper.getInstance().readTxtFile(GenerateConfig.getServiceTemplatePath());
            if (!map.isEmpty()) {
                handle(map, info, GenerateConfig.getServiceSrcPath());
                WriteTemplateHelper.writeSrc(info.getServiceSrcPath(), info.getServiceSuffix(), map ,info.getCoverService(),info);
            }
        }
    }

    public static void generateServiceImpl(GenerateInfo info) {
        if(info.getGenerateServiceImpl()){
            Map<Integer,String> map = ReadTemplateHelper.getInstance().readTxtFile(GenerateConfig.getServiceImplTemplatePath());
            if (!map.isEmpty()) {
                handle(map, info, GenerateConfig.getServiceImplSrcPath());
                WriteTemplateHelper.writeSrc(info.getServiceImplSrcPath(), info.getServiceImplSuffix(), map ,info.getCoverServiceImpl(),info);
            }
        }
    }

    public static void generateMapper(GenerateInfo info) {
        if(info.getGenerateMapper()){
            Map<Integer,String> map = ReadTemplateHelper.getInstance().readTxtFile(GenerateConfig.getMapperTemplatePath());
            if (!map.isEmpty()) {
                handle(map, info, GenerateConfig.getMapperSrcPath());
                WriteTemplateHelper.writeSrc(info.getMapperSrcPath(), info.getMapperSuffix(), map ,info.getCoverMapper(),info);
            }
        }
    }

    public static void generateMapperXml(GenerateInfo info) {
        if(info.getGenerateMapperXml()){
            Map<Integer,String> map = ReadTemplateHelper.getInstance().readTxtFile(GenerateConfig.getMapperXmlTemplatePath());
            if (!map.isEmpty()) {
                if(info.getFieldColumnList()==null){
                    List<FieldColumn> fieldColumnList = GenerateUtil.getFieldList(info.getCla());
                    info.setFieldColumnList(fieldColumnList);
                }
                handle(map,info,GenerateConfig.getMapperXmlSrcPath());
                WriteTemplateHelper.writeResource(info.getMapperXmlSrcPath(), info.getMapperXmlSuffix(),map ,info.getCoverMapperXml(),info);
            }
        }
    }

    public static void generateSql(GenerateInfo info) {
        if(info.getGenerateSql()){
            List<FieldColumn> fieldColumnList = info.getFieldColumnList();
            if(info.getFieldColumnList()==null){
                fieldColumnList = GenerateUtil.getFieldList(info.getCla());
                info.setFieldColumnList(fieldColumnList);
            }

            String tableName = info.getTableName();
            GenerateString gs = GenerateString.build();
            GenerateString gsAdd = GenerateString.build();
            gs.append("CREATE TABLE `").append(tableName).append("` (").appendRN();
            for(FieldColumn field : fieldColumnList){
                gs.append("`"+field.getFieldColumn()+"` ").append(field.getJdbcType())
                        .append(field.getLength()+" ");

                gsAdd.append("ALTER TABLE `").append(tableName).append("` ")
                        .append("ADD COLUMN ").append(field.getFieldColumn())
                        .append(" ").append(field.getJdbcType()).append(field.getLength())
                        .append(" ").append(" DEFAULT NULL ");

                if(field.getPrimaryKey()){
                    gs.append(" NOT NULL AUTO_INCREMENT ");
                }else{
                    gs.append(" DEFAULT NULL ");
                }
                if(field.getComment()!=null){
                    gs.append(" COMMENT '").append(field.getComment()).append("'");
                    gsAdd.append(" COMMENT '").append(field.getComment()).append("'");
                }
                gs.append(",").appendRN();
                gsAdd.appendSRN();
            }
            for(FieldColumn field : fieldColumnList) {
                if(field.getPrimaryKey()){
                    gs.append("PRIMARY KEY (`").append(field.getFieldColumn()).append("`)").appendRN();
                }
            }
            gs.append(")").append("ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8").appendSRN();
            Map<Integer,String> map = new HashMap<Integer, String>();
            map.put(0,"-- 建表语句");
            map.put(1,gs.toString());
            map.put(2,"-- 新增字段");
            map.put(3,gsAdd.toString());
            WriteTemplateHelper.writeResource(info.getSqlSrcPath(), info.getSqlSuffix(),map ,info.getCoverSql(),info);
        }
    }

    public static void handle(Map<Integer,String> map,GenerateInfo info,String pack){
        Pattern p = Pattern.compile("\\$\\{(.*?)}");
        Set<String> importSet = new HashSet<String>();
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            // 匹配
            Matcher matcher = p.matcher(entry.getValue());
            // 处理匹配到的值
            String str = null;
            String str2 = null;
            String reg = null;
            while (matcher.find()) {
                str = matcher.group();
                str2 = str.substring(2,str.length()-1).trim();
                reg = "\\$\\{"+str.substring(2,str.length()-1)+"\\}";
                String parentPackage1 = StringUtils.isNotBlank(info.getParentPackage())?"."+info.getParentPackage():"";
                String parentPackage2 = StringUtils.isNotBlank(info.getParentPackage())?"/"+info.getParentPackage():"";
                String parentPackage3 = StringUtils.isNotBlank(info.getParentPackage())?info.getParentPackage()+".":"";
                if("package".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,"package "+info.getBasePackage()+"."+pack+parentPackage1+";"));
                }
                else if("voName".equalsIgnoreCase(str2)){
                    if(!GenerateConfig.getVoSrcPath().equals(pack)){
                        importSet.add(info.getVoSrcPath());
                    }
                    entry.setValue(entry.getValue().replaceAll(reg,info.getVoName()));
                }else if("lowerVoName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getVoLowerName()));
                }else if("className".equalsIgnoreCase(str2)){
                    importSet.add(info.getCla().getName());
                    entry.setValue(entry.getValue().replaceAll(reg,info.getClassName()));
                }else if("logName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,parentPackage3+info.getClassName()));
                }else if("dataSource".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getDataSource()));
                }else if("lowerClassName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getLowerClassName()));
                }else if("serviceName".equalsIgnoreCase(str2)){
                    if(!GenerateConfig.getServiceSrcPath().equals(pack)){
                        importSet.add(info.getServiceSrcPath());
                    }
                    entry.setValue(entry.getValue().replaceAll(reg,info.getServiceName()));
                }else if("lowerServiceName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getServiceLowerName()));
                }else if("controllerName".equalsIgnoreCase(str2)){
                    if(!GenerateConfig.getControllerSrcPath().equals(pack)){
                        importSet.add(info.getControllerSrcPath());
                    }
                    entry.setValue(entry.getValue().replaceAll(reg,info.getControllerName()));
                }else if("lowerControllerName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getControllerLowerName()));
                }else if("serviceImplName".equalsIgnoreCase(str2)){
                    if(!GenerateConfig.getServiceImplSrcPath().equals(pack)){
                        importSet.add(info.getServiceImplSrcPath());
                    }
                    entry.setValue(entry.getValue().replaceAll(reg,info.getServiceImplName()));
                }else if("lowerServiceImplName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getServiceImplLowerName()));
                }else if("mapperName".equalsIgnoreCase(str2)){
                    if(!GenerateConfig.getMapperSrcPath().equals(pack)){
                        importSet.add(info.getMapperSrcPath());
                    }
                    entry.setValue(entry.getValue().replaceAll(reg,info.getMapperName()));
                }else if("lowerMapperName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getMapperLowerName()));
                }else if("constructor".equalsIgnoreCase(str2)){

                }else if("classComment".equalsIgnoreCase(str2)){
                    GenerateString gs = GenerateString.build().appendDesc(info, DescType.CLASS,0);
                    entry.setValue(gs.toString());
                }else if("selectListComment".equalsIgnoreCase(str2)){
                    GenerateString gs = GenerateString.build().appendDesc(info, DescType.SELECT_LIST,1);
                    entry.setValue(gs.toString());
                }else if("selectOneComment".equalsIgnoreCase(str2)){
                    GenerateString gs = GenerateString.build().appendDesc(info, DescType.SELECT_ONE,1);
                    entry.setValue(gs.toString());
                }else if("insertComment".equalsIgnoreCase(str2)){
                    GenerateString gs = GenerateString.build().appendDesc(info, DescType.INSERT,1);
                    entry.setValue(gs.toString());
                }else if("updateComment".equalsIgnoreCase(str2)){
                    GenerateString gs = GenerateString.build().appendDesc(info, DescType.UPDATE,1);
                    entry.setValue(gs.toString());
                }else if("deleteComment".equalsIgnoreCase(str2)){
                    GenerateString gs = GenerateString.build().appendDesc(info, DescType.DELETE,1);
                    entry.setValue(gs.toString());
                }else if("requestMapping".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,parentPackage2+info.getClassMapping()));
                }else if("mapperPackage".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getMapperSrcPath()));
                }else if("classPackage".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getCla().getName()));
                }else if("voPackage".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getVoSrcPath()));
                }else if("tableName".equalsIgnoreCase(str2)){
                    entry.setValue(entry.getValue().replaceAll(reg,info.getTableName()));
                }

                if(str2.startsWith("each::") || str2.startsWith("eachNotId::")){
                    String express = str2.split("::")[1];
                    List<String> resultList = new ArrayList<String>();
                    Pattern p0 = Pattern.compile("@\\[(.*?)\\]");
                    String str0 = null;
                    String strTrim0 = null;
                    String reg0 = null;
                    int index = 0;
                    boolean flag = false;
                    if(str2.startsWith("eachNotId::")){
                        flag = true;
                    }
                    for (FieldColumn fieldColumn : info.getFieldColumnList()){
                        if(flag && fieldColumn.getPrimaryKey()){
                            continue;
                        }
                        Matcher matcher0 = p0.matcher(express);
                        String result = express;
                        while (matcher0.find()) {
                            str0 = matcher0.group();
                            strTrim0 = str0.substring(2, str0.length() - 1).trim();
                            reg0 = "@\\[" + str0.substring(2, str0.length() - 1) + "\\]";
                            if ("column".equalsIgnoreCase(strTrim0)) {
                                result = result.replaceAll(reg0,fieldColumn.getFieldColumn());
                            }else if("property".equalsIgnoreCase(strTrim0)){
                                String content = fieldColumn.getFieldName();
                                if("java.lang.String".equalsIgnoreCase(fieldColumn.getFieldType())){
                                    content = fieldColumn.getFieldName()+" != '' and "+ fieldColumn.getFieldName();
                                }
                                result = result.replaceAll(reg0,content);
                            }else if("_column".equalsIgnoreCase(strTrim0)){
                                if(index!=info.getFieldColumnList().size()-1){
                                    result = result.replaceAll(reg0,fieldColumn.getFieldColumn()+",");
                                }else{
                                    result = result.replaceAll(reg0,fieldColumn.getFieldColumn());
                                }
                            }else if("_property".equalsIgnoreCase(strTrim0)){
                                result = result.replaceAll(reg0,"#{"+fieldColumn.getFieldName()+"}");
                            }else if("jdbcType".equalsIgnoreCase(strTrim0)){
                                result = result.replaceAll(reg0,fieldColumn.getJdbcType());
                            }
                        }
                        index++;
                        resultList.add(result);
                    }

                    reg = reg.replaceAll("\\[","\\\\[");
                    reg = reg.replaceAll("\\]","\\\\]");
                    reg = reg.replaceAll("\\#\\{","\\\\#\\\\{");
                    GenerateString gs = GenerateString.build();
                    for (int i=0;i<resultList.size();i++){
                        gs.append(entry.getValue().replaceAll(reg,"")).append(resultList.get(i));
                        if(i!=resultList.size()-1){
                            gs.appendRN();
                        }
                    }
                    entry.setValue(gs.toString());
                }
            }
        }

        GenerateString generateString = GenerateString.build().appendImport(importSet);
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            // 匹配
            Matcher matcher = p.matcher(entry.getValue());
            // 处理匹配到的值
            String str = null;
            String str2 = null;
            String reg = null;
            while (matcher.find()) {
                str = matcher.group();
                str2 = str.substring(2, str.length() - 1).trim();
                reg = "\\$\\{" + str.substring(2, str.length() - 1) + "\\}";
                if ("import".equalsIgnoreCase(str2)) {
                    entry.setValue(entry.getValue().replaceAll(reg,generateString.toString()));
                }
            }
        }
    }


    public static String foreachMap(Map<Integer,String> map){
        StringBuffer sb = new StringBuffer();
        System.out.println("-------------------------------------");
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getValue());
            sb.append(entry.getValue());
        }
        System.out.println("-------------------------------------");
        return sb.toString();
    }
}
