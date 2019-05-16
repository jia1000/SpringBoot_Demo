package com.example.demo;

import com.example.demo.resolver.CustomMultipartResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
@Configuration
// 定时任务 ： 1、添加注解
@EnableScheduling
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    //4、在启动类中配置,启用上传文件功能
    @Bean(name="multipartResolver")
    public MultipartResolver multipartResolver() {
        return new CustomMultipartResolver();
    }
}
