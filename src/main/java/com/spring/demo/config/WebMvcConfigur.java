package com.spring.demo.config;

import com.spring.demo.interceptor.TraceIdInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 容器配置说明.
 *
 */

@Configuration
@EnableAutoConfiguration
public class WebMvcConfigur implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {

        /**TraceId设置*/
        registry.addInterceptor(new TraceIdInterceptor());
    }
}