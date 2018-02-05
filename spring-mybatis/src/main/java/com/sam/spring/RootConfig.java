package com.sam.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.naming.NamingException;

/**
 * 定义扫描的根路径,数据源
 * Created by sam on 16/5/26.
 */
@Configuration
@ComponentScan(basePackages = "com.sam")
@MapperScan(basePackages = "com.sam")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RootConfig {

    private static String diver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql://localhost:3306/sonepar";

    private static String user = "root";

    private static String pwd = "1101";

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(diver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }


    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws NamingException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext ap) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.sam");
        return sessionFactory;
    }

}
