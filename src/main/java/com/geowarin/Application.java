package com.geowarin;

import com.geowarin.config.JerseyConfig;
import com.geowarin.rest.RestResource;
import com.geowarin.service.ArticleService;
import com.geowarin.service.MessageService;


import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Date: 22/12/13
 * Time: 18:03
 *
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = {RestResource.class, MessageService.class, ArticleService.class, ArticleDAO.class})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Application.class, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }
}
