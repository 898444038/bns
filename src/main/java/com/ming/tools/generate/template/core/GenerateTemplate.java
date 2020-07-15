package com.ming.tools.generate.template.core;

import com.ming.tools.generate.template.utils.ScannerAnno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class GenerateTemplate {
    private volatile static GenerateTemplate generate = null;
    private GenerateTemplate(){}
    public static GenerateTemplate getInstance()   {
        if (generate == null)  {
            synchronized (GenerateTemplate.class) {
                if (generate== null)  {
                    generate= new GenerateTemplate();
                }
            }
        }
        return generate;
    }

    public void create(String path) throws Exception {
        String[] paths = {path};
        create(paths);
    }

    public void create(String[] paths) throws Exception {
        System.out.println("generate file...");
        ScannerAnno scanner = new ScannerAnno();
        List<GenerateInfo> list = new ArrayList<GenerateInfo>();
        for (String path : paths){
            list.addAll(scanner.getScannerAnnoList(path));
        }

        for (GenerateInfo info : list) {
            GenerateHelper.generateVo(info);
            GenerateHelper.generateService(info);
            GenerateHelper.generateController(info);
            GenerateHelper.generateServiceImpl(info);
            GenerateHelper.generateMapper(info);
            GenerateHelper.generateMapperXml(info);
            GenerateHelper.generateSql(info);
        }
        System.out.println("generate file complete!");
    }
}
