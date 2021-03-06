package com.ming.tools.generate.template.scan;


import com.ming.tools.generate.template.enable.GenerateRegistry;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({GenerateScanRegistry.class})
public @interface GenerateScan {
    String[] basePackages() default {};
}
