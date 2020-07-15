package com.ming.tools.generate.template.utils;

import com.ming.tools.generate.template.core.GenerateInfo;
import com.ming.tools.generate.template.enums.DescType;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Administrator on 2019/9/9 0009.
 */
public class GenerateString {

    private StringBuffer sb = null;

    private static final String semicolon = ";";
    private static final String rn = "\r\n";
    private static final String t1 = "\t";
    private static final String t2 = "\t\t";
    private static final String blank_space1 = " ";

    public GenerateString(){}

    public static GenerateString build(){
        GenerateString gs = new GenerateString();
        gs.newStringBuffer();
        return gs;
    }

    public void newStringBuffer(){
        sb = new StringBuffer();
    }

    public GenerateString append(String str){
        sb.append(str);
        return this;
    }

    public GenerateString appendT(int i){
        for(int j=0;j<i;j++){
            sb.append(t1);
        }
        return this;
    }

    public GenerateString appendRN(){
        sb.append(rn);
        return this;
    }

    public GenerateString appendSRN(){
        sb.append(semicolon+rn);
        return this;
    }

    public GenerateString appendDesc(GenerateInfo info, DescType type, int i){
        appendT(i).append("/**").appendRN();
        appendT(i).append(" * ");
        if(DescType.CLASS.equals(type)){
            append(info.getDesc());
        }else{
            append(type.getName());
        }
        appendRN();
        appendT(i).append(" * @author: ").append(info.getUserName()).appendRN();
        appendT(i).append(" * @date: ").append(LocalDate.now().toString()).appendRN();
        appendT(i).append(" */");
        return this;
    }

    public GenerateString appendImport(Class... clazzs){
        for(Class clazz : clazzs){
            append("import ").append(clazz.getName()).appendSRN();
        }
        return this;
    }


    public GenerateString appendImport(Set<String> importSet){
        for(String str : importSet){
            append("import ").append(str).appendSRN();
        }
        return this;
    }

    public GenerateString appendImport(String str){
        if(!sb.toString().contains("import "+str+";")){
            append("import ").append(str).appendSRN();
        }
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
