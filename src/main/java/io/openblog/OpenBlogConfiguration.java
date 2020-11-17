package io.openblog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.openblog.service.FileBlogService;
import io.openblog.service.IBlogService;

@Configuration

public class OpenBlogConfiguration {
 

    
    @Bean()
    public IBlogService blogService() {
        return new FileBlogService();
    }
 

}