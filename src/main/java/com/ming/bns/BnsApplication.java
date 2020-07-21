package com.ming.bns;

import com.ming.bns.system.config.CrosFilter;
import com.ming.tools.generate.template.enable.EnableGenerate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@MapperScan(basePackages = {
	"com.ming.bns.admin.mapper"
})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableGenerate(basePackages = {"com.ming.bns.admin"})
public class BnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BnsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean registerFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addUrlPatterns("/*");
		bean.setFilter(new CrosFilter());
		return bean ;
	}
}
