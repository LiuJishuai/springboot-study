package com.jeyson.springboot.config;

import com.jeyson.springboot.interceptor.CheckLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: liujishuai
 * @Time: 2018/2/28 14:34
 * @Description:
 */
@Configuration
public class SpringBootConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckLoginInterceptor());
    }
}
