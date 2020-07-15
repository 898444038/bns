package com.ming.tools.generate.template.utils;

import com.ming.tools.generate.template.annotation.Generate;
import com.ming.tools.generate.template.annotation.GenerateController;
import com.ming.tools.generate.template.annotation.GenerateService;
import com.ming.tools.generate.template.annotation.GenerateServiceImpl;
import com.ming.tools.generate.template.annotation.GenerateVo;
import com.ming.tools.generate.template.annotation.database.mysql.GenerateSql;
import com.ming.tools.generate.template.annotation.orm.mybatis.GenerateMapper;
import com.ming.tools.generate.template.annotation.orm.mybatis.GenerateMapperXml;
import com.ming.tools.generate.template.core.GenerateConfig;
import com.ming.tools.generate.template.core.GenerateInfo;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class ScannerAnno {

    private static final String userName = System.getenv().get("USERNAME");// 获取用户名

    //找也用了Controller注解的类
    private Set<Class<?>> annos;
    private List<GenerateInfo> annoList;

    public List<GenerateInfo> getScannerAnnoList(String packageName) throws Exception{
        GenerateInfo info = null;
        String name = null;
        if (annoList == null) {
            annoList = new ArrayList<GenerateInfo>();
            Set<Class<?>> clsList = getClasses(packageName);
            if (clsList != null && clsList.size() > 0) {
                for (Class<?> cls : clsList) {
                    Generate generate = cls.getAnnotation(Generate.class);
                    if (generate != null) {
                        if(!generate.isEffective()){
                            continue;
                        }
                        GenerateVo generateVo = cls.getAnnotation(GenerateVo.class);
                        GenerateController generateController = cls.getAnnotation(GenerateController.class);
                        GenerateService generateService = cls.getAnnotation(GenerateService.class);
                        GenerateServiceImpl generateServiceImpl = cls.getAnnotation(GenerateServiceImpl.class);
                        GenerateMapper generateMapper = cls.getAnnotation(GenerateMapper.class);
                        GenerateMapperXml generateMapperXml = cls.getAnnotation(GenerateMapperXml.class);
                        GenerateSql generateSql = cls.getAnnotation(GenerateSql.class);
                        info = new GenerateInfo();
                        info.setCla(cls);
                        if(generateVo!=null){info.setGenerateVo(true);}
                        if(generateController!=null){info.setGenerateController(true);}
                        if(generateService!=null){info.setGenerateService(true);}
                        if(generateServiceImpl!=null){info.setGenerateServiceImpl(true);}
                        if(generateMapper!=null){info.setGenerateMapper(true);}
                        if(generateMapperXml!=null){info.setGenerateMapperXml(true);}
                        if(generateSql!=null){info.setGenerateSql(true);}
                        if(generateVo==null&&generateController==null&&generateService==null&&generateServiceImpl==null&&generateMapper==null&&generateMapperXml==null&&generateSql==null){
                            info.setGenerateVo(true);
                            info.setGenerateController(true);
                            info.setGenerateService(true);
                            info.setGenerateServiceImpl(true);
                            info.setGenerateMapper(true);
                            info.setGenerateMapperXml(true);
                            info.setGenerateSql(true);
                        }

                        info.setIsLog(generate.isLog());

                        if(generate.isCover()){
                            info.setCoverVo(generate.isCover());
                            info.setCoverController(generate.isCover());
                            info.setCoverService(generate.isCover());
                            info.setCoverServiceImpl(generate.isCover());
                            info.setCoverMapper(generate.isCover());
                            info.setCoverMapperXml(generate.isCover());
                            info.setCoverSql(generate.isCover());
                        }
                        if(generateVo!=null){info.setCoverVo(generateVo.isCover());}
                        if(generateController!=null){info.setCoverController(generateController.isCover());}
                        if(generateService!=null){info.setCoverService(generateService.isCover());}
                        if(generateServiceImpl!=null){info.setCoverServiceImpl(generateServiceImpl.isCover());}
                        if(generateMapper!=null){info.setCoverMapper(generateMapper.isCover());}
                        if(generateMapperXml!=null){info.setCoverMapperXml(generateMapperXml.isCover());}
                        if(generateSql!=null){info.setCoverSql(generateSql.isCover());}

                        info.setUserName(userName);
                        info.setDesc(generate.desc());

                        String className = GenerateUtil.getClassName(cls);
                        String lowerClassName = GenerateUtil.firstLowerCase(className);
                        info.setClassName(className);
                        info.setLowerClassName(lowerClassName);

                        String tablePrefix = generate.tablePrefix();
                        if(!GenerateUtil.isBlank(tablePrefix)){
                            tablePrefix = tablePrefix+"_";
                        }

                        String tableName = generate.tableName();
                        if(GenerateUtil.isBlank(tableName)){
                            tableName = GenerateUtil.humpToLine2(className);
                        }
                        info.setTableName(tablePrefix+tableName);

                        String classMapping = generate.classMapping();
                        if(GenerateUtil.isBlank(classMapping)){
                            classMapping = GenerateUtil.humpToBias(className);
                        }
                        info.setClassMapping(classMapping);

                        String baseUrl = generate.baseUrl();
                        info.setBaseUrl(baseUrl);

                        info.setBasePackage(packageName);
                        info.setModuleName(generate.moduleName());

                        name = GenerateUtil.firstUpperCase(GenerateConfig.getControllerSrcPath());
                        info.setControllerName(className + name);
                        info.setControllerLowerName(lowerClassName + name);

                        name = GenerateUtil.firstUpperCase(GenerateConfig.getVoSrcPath());
                        info.setVoName(className + name);
                        info.setVoLowerName(lowerClassName + name);

                        name = GenerateUtil.firstUpperCase(GenerateConfig.getServiceSrcPath());
                        info.setServiceName(className + name);
                        info.setServiceLowerName(lowerClassName + name);

                        String[] arr = GenerateConfig.getServiceImplSrcPath().split("\\.");
                        name = GenerateUtil.firstUpperCase(arr[0])+GenerateUtil.firstUpperCase(arr[1]);
                        info.setServiceImplName(className + name);
                        info.setServiceImplLowerName(lowerClassName + name);

                        name = GenerateUtil.firstUpperCase(GenerateConfig.getMapperSrcPath());
                        info.setMapperName(className + name);
                        info.setMapperLowerName(lowerClassName + name);

                        info.setVoSrcPath(packageName+"."+GenerateConfig.getVoSrcPath()+"."+info.getVoName());
                        info.setControllerSrcPath(packageName+"."+GenerateConfig.getControllerSrcPath()+"."+info.getControllerName());
                        info.setServiceSrcPath(packageName+"."+GenerateConfig.getServiceSrcPath()+"."+info.getServiceName());
                        info.setServiceImplSrcPath(packageName+"."+GenerateConfig.getServiceImplSrcPath()+"."+info.getServiceImplName());
                        info.setMapperSrcPath(packageName+"."+GenerateConfig.getMapperSrcPath()+"."+info.getMapperName());
                        info.setMapperXmlSrcPath("/"+GenerateConfig.getMapperXmlSrcPath()+"/"+info.getMapperName());
                        info.setSqlSrcPath("/"+GenerateConfig.getSqlSrcPath()+"/"+className);

                        info.setVoSuffix(".java");
                        info.setControllerSuffix(".java");
                        info.setServiceSuffix(".java");
                        info.setServiceImplSuffix(".java");
                        info.setMapperSuffix(".java");
                        info.setMapperXmlSuffix(".xml");
                        info.setSqlSuffix(".sql");
                        annoList.add(info);
                    }
                }
            }
        }
        return annoList;
    }

    public Set<Class<?>> getScannerAnno(String packageName) throws Exception{
        if (annos == null) {
            annos = new HashSet<Class<?>>();
            Set<Class<?>> clsList = getClasses(packageName);
            if (clsList != null && clsList.size() > 0) {
                for (Class<?> cls : clsList) {
                    Generate generate = cls.getAnnotation(Generate.class);
                    if (generate != null) {
                        annos.add(cls);
                    }
                }
            }
        }
        return annos;
    }



    /**
     * 从包package中获取所有的Class
     *
     * @param packageName
     * @return
     */
    public Set<Class<?>> getClasses(String packageName) throws Exception{

        // 第一个class类的集合
        //List<Class<?>> classes = new ArrayList<Class<?>>();
        Set<Class<?>> classes = new HashSet<Class<?>>();
        // 是否循环迭代
        boolean recursive = true;
        // 获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                // 如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中，以下俩种方法都可以
                    //网上的第一种方法，
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                    //网上的第二种方法
                    //addClass(classes,filePath,packageName);
                } else if ("jar".equals(protocol)) {
                    // 如果是jar包文件
                    // 定义一个JarFile
                    JarFile jar;
                    try {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/') {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx).replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                                        try {
                                            // 添加到classes
                                            classes.add(Class.forName(packageName + '.' + className));
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }


    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName,
                                                        String packagePath, final boolean recursive, Set<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory())
                        || (file.getName().endsWith(".class"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "."
                                + file.getName(), file.getAbsolutePath(), recursive,
                        classes);
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0,
                        file.getName().length() - 6);
                try {
                    // 添加到集合中去
                    //classes.add(Class.forName(packageName + '.' + className));
                    //经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    // log.error("添加用户自定义视图类错误 找不到此类的.class文件");
                    e.printStackTrace();
                }
            }
        }
    }
}
