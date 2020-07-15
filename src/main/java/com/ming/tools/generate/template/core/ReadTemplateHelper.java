package com.ming.tools.generate.template.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class ReadTemplateHelper {

    private volatile static ReadTemplateHelper instance = null;

    private ReadTemplateHelper(){}

    public static ReadTemplateHelper getInstance(){
        if (instance==null){
            synchronized (ReadTemplateHelper.class){
                if (instance==null){
                    instance = new ReadTemplateHelper();
                }
            }
        }
        return instance;
    }

    public Map<Integer,String> readTxtFile(String filePath){
        Map<Integer,String> map = new HashMap<Integer, String>();
        try {
            URL url = getClass().getResource(filePath);
            File file = new File(url.getPath());
            String encoding="utf-8";
            //File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader read = new InputStreamReader(fis,encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int i = 0;
                while((lineTxt = bufferedReader.readLine()) != null){
                    //System.out.println(lineTxt);
                    map.put(++i,lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return map;
    }


    public static void main(String[] args) {
        //InputStream input = ReadTemplateHelper.class.getResourceAsStream("/word_refine.txt");
        ReadTemplateHelper helper = new ReadTemplateHelper();
        Map<Integer,String> map = helper.readTxtFile("/template/controller.txt");
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
