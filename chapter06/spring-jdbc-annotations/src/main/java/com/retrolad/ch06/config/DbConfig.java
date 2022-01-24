package com.retrolad.ch06.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@PropertySource("classpath:db/jdbc2.properties")
@ComponentScan(basePackages = {"com.retrolad.ch06"})
public class DbConfig {

    private static Logger logger = LoggerFactory.getLogger(DbConfig.class);

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${user_name}")
    private String username;
    @Value("${password}")
    private String password;

    // Resolves ${} properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        try {
            // Simple DataSource implementation, configuring JDBC Driver
            // via properties, does not provide pooling, so generally used
            // only for testing purposes
//            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
//            dataSource.setDriverClass(driver);
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            logger.error("DBCP DataSource bean cannot be created", e);
            return null;
        }
    }

}
