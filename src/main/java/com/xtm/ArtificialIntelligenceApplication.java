package com.xtm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@SpringBootApplication
public class ArtificialIntelligenceApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        log.info("系统已经启动");
        return builder.sources(ArtificialIntelligenceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ArtificialIntelligenceApplication.class, args);
    }

}
