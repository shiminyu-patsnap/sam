package com.sam;

import com.sam.feature.condition.*;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by sam on 16/6/27.
 */
@SpringBootApplication
@ComponentScan("com.sam")
//启用aop
@EnableAspectJAutoProxy
//动态指定配置文件
@PropertySource("classpath:sam.properties")
@EnableAsync
@EnableScheduling
public class SamApplication implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SamApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SamApplication.class);
//        context.getBean(SamService.class).queryUserName("shiminyu@qq.com");
    }

    /**
     * 动态注册配置文件
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    @Bean
    @Conditional(WindowCondition.class)
    public ListService windowService() {
        return new WindowService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxService() {
        return new LinuxService();
    }
}

