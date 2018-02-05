package com.sam.spring;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sam.common.SpringUtils;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.n3r.diamond.client.Miner;
import org.n3r.diamond.client.Minerable;
import org.n3r.diamond.sdk.DiamondSDK;
import org.n3r.diamond.sdk.domain.DiamondConf;
import org.n3r.diamond.sdk.domain.DiamondSDKConf;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * 继承web mvc adapter
 * 包含通用的配置
 * Created by sam on 16/5/26.
 */
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    //static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }


    // 配置thymeleaf视图解析器,
    // 保留原有配置
    // 加入自定义参数 如${e.res()}
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        Map<String, Object> oldStaticVariables = viewResolver.getStaticVariables();
        Map<String, Object> staticVariables = Maps.newHashMap(oldStaticVariables);
        staticVariables.put("e", new SpringUtils());

        viewResolver.setStaticVariables(staticVariables);

        return viewResolver;
    }

    //配置模板引擎
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.addDialect(new LayoutDialect());
        return engine;
    }

    //配置模板解析器
    @Bean
    public TemplateResolver templateResolver() {
        ClassLoaderTemplateResolver templateResolver;
        templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("views/");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false); // true by default

        return templateResolver;
    }

    //定义spring文件上传编码
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    //实现国际化的文件属性动态加载
    @Bean(name = "messageSource")
    public MessageSource configureMessageSource() {
        MultipleMessageSource messageSource = new MultipleMessageSource();
        messageSource.setBasename("classpath*:i18n/*");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

    //解析json返回数据
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList(converter.getSupportedMediaTypes());
        converter.setSupportedMediaTypes(mediaTypes);
        mediaTypes.addAll(asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.TEXT_XML));
        converters.add(converter);
    }


    //配置diamond
    @Bean
    public DiamondSDK diamondSDK() {
        Minerable minerable = new Miner().getMiner("poet.diamond", "diamondConfig");
        DiamondSDK diamondSDK = new DiamondSDK(
                new DiamondSDKConf(
                        Lists.newArrayList(new DiamondConf(
                                minerable.getString("diamondIp"),
                                minerable.getInt("diamondPort"),
                                minerable.getString("diamondUsername"),
                                minerable.getString("diamondPassword")))));
        return diamondSDK;
    }

    //快捷定义ViewController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
