package io.openblog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.openblog.service.CosmosDBBlogService;
import io.openblog.service.FileBlogService;
import io.openblog.service.IBlogService;

@Configuration

public class OpenBlogConfiguration {
 

    @Bean
    public IBlogService blogService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies.xml");

        return context.getBean("blogService", IBlogService.class);
        
    }
 

}