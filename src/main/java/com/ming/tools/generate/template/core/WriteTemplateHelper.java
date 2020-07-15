package com.ming.tools.generate.template.core;

import com.ming.tools.generate.template.utils.GenerateUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class WriteTemplateHelper {

    private static final String mavenJavaPath = "src\\main\\java\\";
    private static final String mavenResourcesPath = "src\\main\\resources\\";

    public static String getAbsolutePath(String fileName,String moduleName,Integer type) {
        File f = new File(".");
        String absolutePath = f.getAbsolutePath();
        absolutePath = absolutePath.substring(0,absolutePath.length()-1);
        String mavenPath = "";
        if(GenerateUtil.isNotBlank(moduleName)){
            mavenPath += (moduleName+"\\");
        }
        if(type == 0){
            mavenPath += mavenJavaPath;
        }else{
            mavenPath += mavenResourcesPath;
        }
        String packagePath = fileName.replaceAll("\\.","\\\\");
        return absolutePath+mavenPath+packagePath;
    }

    public static void writeSrc(String fileName,String suffix,Map<Integer,String> map,Boolean isCover,GenerateInfo info) {
        String filePath = getAbsolutePath(fileName,info.getModuleName(),0) + suffix;
        String filedo = fileLinesWrite(filePath,map,false,isCover,info.getIsLog());
        System.out.println(filedo+" ["+filePath + "] success!");
    }

    public static void writeResource(String fileName, String suffix, Map<Integer, String> map,Boolean isCover,GenerateInfo info) {
        String filePath = getAbsolutePath(fileName,info.getModuleName(),1) + suffix;
        String filedo = fileLinesWrite(filePath,map,false,isCover,info.getIsLog());
        System.out.println(filedo+" ["+filePath + "] success!");
    }

    /**
     * 文件数据写入（如果文件夹和文件不存在，则先创建，再写入）
     * @param filePath
     * @param map
     * @param flag true:如果文件存在且存在内容，则内容换行追加；false:如果文件存在且存在内容，则内容替换
     * @param isCover true:覆盖
     */
    public static String fileLinesWrite(String filePath,Map<Integer,String> map,boolean flag,boolean isCover,boolean isLog){
        String filedo = "write";
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            File file=new File(filePath);
            //如果文件夹不存在，则创建文件夹
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            if(!file.exists()){//如果文件不存在，则创建文件,写入第一行内容
                file.createNewFile();
                fw = new FileWriter(file);
                filedo = "create";
            }else{//如果文件存在,则追加或替换内容
                filedo = "文件已存在";
                if(isCover){
                    filedo+="[覆盖]";
                    fw = new FileWriter(file, flag);
                }else{
                    filedo+="[跳过]";
                    return filedo;
                }
            }
            pw = new PrintWriter(fw);
            for (Map.Entry<Integer,String> entry : map.entrySet()){
                pw.println(entry.getValue());
            }
            if(isLog){
                GenerateHelper.foreachMap(map);
            }
            pw.flush();
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(pw!=null){
                pw.close();
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return filedo;
    }
}
