package com.ming.tools.generate.template.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

/**
 * GenerateBuilder 注解解析器
 * Created by Administrator on 2020/3/16 0016.
 */
/*
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Annotation.toBuilder","Annotation.BuilderClass"})
public class GenerateBuilderProcess extends AbstractProcessor {
    private Filer filer;
    private String className;

    //essential为真的属性名
    private List<String> fields_t;
    //essential为假的属性名
    private List<String> fields_f;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //标记的类
        Set<? extends Element> classAnnotated = roundEnv.getElementsAnnotatedWith(BuilderClass.class);
        for (Element classelement :classAnnotated){
            className = classelement.getSimpleName().toString();
        }
        //标记的成员变量
        Set<? extends Element> fieldAnnotated = roundEnv.getElementsAnnotatedWith(toBuilder.class);
        for (Element field: fieldAnnotated){
            if(field.getAnnotation(toBuilder.class).essential()) {
                fields_t.add(field.getSimpleName().toString());
            }else{
                fields_f.add(field.getSimpleName().toString());
            }
        }
        //创建源文件
        createFile();

        return true;
    }


    private void createFile() {

        StringBuilder cls = new StringBuilder();
        cls.append("package Annotation;\n\npublic class ").append(className);
        //源文件内容，根据之前注解信息拼接字符串；
        try {
            JavaFileObject sourceFile = filer.createSourceFile("Annotation." + className);
            Writer writer = sourceFile.openWriter();
            writer.write(cls.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
