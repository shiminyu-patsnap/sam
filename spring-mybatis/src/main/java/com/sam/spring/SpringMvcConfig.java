package com.sam.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * 实际使用到的配置文件
 * 可以将该文件放入不同的工程来辨别使用不同的spring配置,如不同的interceptor
 * Created by sam on 16/5/26.
 */
@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
public class SpringMvcConfig extends WebMvcConfig {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SpringInterceptor());
    }


}
