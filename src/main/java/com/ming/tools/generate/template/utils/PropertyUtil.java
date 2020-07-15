package com.ming.tools.generate.template.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
    public static Map<String,String> getProperty(String name) {
        Properties prop = new Properties();
        Map<String,String> map = new HashMap<String, String>();
        try{
            //读取属性文件a.properties
//            InputStream in = new BufferedInputStream (new FileInputStream(name));
            InputStream in = PropertyUtil.class.getResourceAsStream(name);
            prop.load(in);     ///加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                //System.out.println(key+":"+prop.getProperty(key));
                map.put(key,prop.getProperty(key));
            }
            in.close();

            ///保存属性到b.properties文件
            /*FileOutputStream oFile = new FileOutputStream("b.properties", true);//true表示追加打开
            prop.setProperty("phone", "10086");
            prop.store(oFile, "The New properties file");
            oFile.close();*/
        } catch(Exception e){
            System.out.println(e);
        }
        return map;
    }
}
