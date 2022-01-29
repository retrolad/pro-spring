package com.retrolad.ch08.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.retrolad.ch08")
@EnableJpaRepositories(basePackages = "com.retrolad.ch08.repos")
// Enable audition via annotation configuration
// auditorAwareRed is used to lookup for the current principal
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class EnversConfig {

    private static final Logger logger = LoggerFactory.getLogger(EnversConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate");
            dataSource.setUsername("postgres");
            dataSource.setPassword("root");
            return dataSource;
        } catch (Exception e) {
            logger.error("DBCP DataSource bean cannot be created", e);
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProps = new Properties();
        hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        hibernateProps.put("hibernate.format_sql", true);
        hibernateProps.put("hibernate.use_sql_comments", true);
        hibernateProps.put("hibernate.show_sql", true);
        hibernateProps.put("hibernate.max_fetch_depth", 3);
        hibernateProps.put("hibernate.jdbc.batch_size", 10);
        hibernateProps.put("hibernate.jdbc.fetch_size", 50);
        // Hibernate envers properties
        hibernateProps.put("org.hibernate.envers.audit_table_suffix", "_H");
        hibernateProps.put("org.hibernate.envers.revision_field_name", "AUDIT_REVISION");
        hibernateProps.put("org.hibernate.envers.revision_type_field_name", "ACTION_TYPE");
        hibernateProps.put("org.hibernate.envers.audit_strategy", "org.hibernate.envers.strategy.ValidityAuditStrategy");
        hibernateProps.put("org.hibernate.envers.audit_strategy_validity_end_rev_field_name", "AUDIT_REVISION_END");
        hibernateProps.put("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp", "True");
        hibernateProps.put("org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name",
                "AUDIT_REVISION_END_TS");
        return hibernateProps;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.retrolad.ch08.entities");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }
}