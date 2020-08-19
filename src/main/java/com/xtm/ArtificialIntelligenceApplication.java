package com.xtm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@Slf4j
@SpringBootApplication
public class ArtificialIntelligenceApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        log.info("系统已经启动");
        return builder.sources(ArtificialIntelligenceApplication.class);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/data/app/temp");//指定临时文件路径
        return factory.createMultipartConfig();
    }

    public static void main(String[] args) {


        SpringApplication.run(ArtificialIntelligenceApplication.class, args);
    }

}
