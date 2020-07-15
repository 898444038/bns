package com.ming.tools.generate.template.utils;

import com.ming.tools.generate.template.annotation.database.Column;
import com.ming.tools.generate.template.annotation.database.Comment;
import com.ming.tools.generate.template.annotation.database.PrimaryKey;
import com.ming.tools.generate.template.annotation.database.Text;
import com.ming.tools.generate.template.core.FieldColumn;
import java.beans.Transient;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class GenerateUtil {

    public static boolean isBlank(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    //获取类名，不带包名
    public static String getClassName(Class clazz){
        String name = clazz.getName();
        String[] names = name.split("\\.");
        return names[names.length-1];
    }


    //首字母大写
    public static String firstUpperCase(String str){
        char[] chars = str.toCharArray();
        chars[0]-=32;
        return String.valueOf(chars);
    }

    //首字母小写
    public static String firstLowerCase(String str){
        char[] chars = str.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }



    private static Pattern linePattern = Pattern.compile("_(\\w)");
    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return firstUpperCase(sb.toString());
    }


    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    public static String humpToLine(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(sb,"_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    /**
     * 驼峰转下划线,效率比上面高
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        String s = sb.toString();
        if(s.length()!=0){
            s = s.substring(1);
        }
        return s;
    }


    public static String humpToBias(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "/" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static List<FieldColumn> getFieldList(Class clazz){
        List<FieldColumn> list = new ArrayList<FieldColumn>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if(field.isAnnotationPresent(Transient.class)){
                continue;
            }
            if(!field.isAnnotationPresent(Column.class)){
                continue;
            }
            String fieldName = field.getName();
            if("serialVersionUID".equals(fieldName)){
                continue;
            }
            FieldColumn fieldColumn = new FieldColumn();
            String typeName = field.getGenericType().getTypeName();
            fieldColumn.setFieldName(fieldName);
            fieldColumn.setFieldColumn(humpToLine(fieldName));
            fieldColumn.setFieldType(typeName);
            if(field.isAnnotationPresent(PrimaryKey.class)){
                fieldColumn.setPrimaryKey(true);
            }else{
                fieldColumn.setPrimaryKey(false);
            }
            if(field.isAnnotationPresent(Comment.class)){
                Comment comment = field.getAnnotation(Comment.class);
                fieldColumn.setComment(comment.value());
            }
            if("java.lang.String".equals(typeName)){
                if(field.isAnnotationPresent(Text.class)){
                    fieldColumn.setJdbcType("TEXT");
                    fieldColumn.setLength("");
                }else{
                    fieldColumn.setJdbcType("VARCHAR");
                    fieldColumn.setLength("(32)");
                }
            }else if("java.lang.Long".equals(typeName)){
                fieldColumn.setJdbcType("BIGINT");
                fieldColumn.setLength("(20)");
            }else if("java.lang.Integer".equals(typeName)){
                fieldColumn.setJdbcType("INTEGER");
                fieldColumn.setLength("(11)");
            }else if("java.util.Date".equals(typeName)){
                fieldColumn.setJdbcType("datetime");
                fieldColumn.setLength("");
            }else if("int".equalsIgnoreCase(typeName)){
                fieldColumn.setJdbcType("BIT");
                fieldColumn.setLength("(11)");
            }else if("java.math.BigDecimal".equalsIgnoreCase(typeName)){
                fieldColumn.setJdbcType("DECIMAL");
                fieldColumn.setLength("(11)");
            }else if("java.lang.Double".equalsIgnoreCase(typeName)){
                fieldColumn.setJdbcType("DECIMAL");
                fieldColumn.setLength("(10,2)");
            }else if("java.lang.Boolean".equalsIgnoreCase(typeName)){
                fieldColumn.setJdbcType("TINYINT");
                fieldColumn.setLength("(1)");
            }else{
                fieldColumn.setJdbcType("");
            }
            list.add(fieldColumn);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(lineToHump("question_category_test"));// questionCategory
        System.out.println(humpToLine2("QuestionCategoryTest"));// question_category
    }
}
