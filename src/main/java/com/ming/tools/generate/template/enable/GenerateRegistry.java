package com.ming.tools.generate.template.enable;

import com.ming.tools.generate.template.core.GenerateConfig;
import com.ming.tools.generate.template.core.GenerateTemplate;
import com.ming.tools.generate.template.scan.GenerateScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2020/4/15 0015.
 */
public class GenerateRegistry implements ImportBeanDefinitionRegistrar {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /*if (logger.isInfoEnabled()) {
            logger.info("RedisRegistry-registerBeanDefinitions begin to init redis configure");
        }*/
        //BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, RedisProperties.class.getName(), RedisProperties.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, GenerateConfig.class.getName(), GenerateConfig.class);


        Map<String, Object> defaultAttrs = importingClassMetadata.getAnnotationAttributes(EnableGenerate.class.getName(), true);
        /*if (defaultAttrs != null && defaultAttrs.size() > 0) {
            System.out.println("Generate package scan: " + buildPackages((String[]) defaultAttrs.get("basePackages")));
        }*/
        if(defaultAttrs!=null && defaultAttrs.size() > 0){
            String[] basePackages = (String[]) defaultAttrs.get("basePackages");
            try {
                GenerateTemplate.getInstance().create(basePackages);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
