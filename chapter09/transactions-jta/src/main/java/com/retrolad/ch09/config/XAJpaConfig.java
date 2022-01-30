package com.retrolad.ch09.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

@Configuration
@EnableJpaRepositories
public class XAJpaConfig {

    private static final Logger logger = LoggerFactory.getLogger(XAJpaConfig.class);

    @Bean
    public DataSource dataSourceA() {
        try {
            AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
            dataSourceBean.setUniqueResourceName("XADBMSA");
            dataSourceBean.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
            dataSourceBean.setXaProperties(xaAProperties());
            dataSourceBean.setPoolSize(1);
            return dataSourceBean;
        } catch (Exception e) {
            logger.error("DataSource been cannot be created!", e);
            return null;
        }
    }

    @Bean
    public Properties xaAProperties() {
        Properties xaProp = new Properties();
        xaProp.put("databaseName", "gamedb_a");
        xaProp.put("user", "prospring5_a");
        xaProp.put("password", "prospring5");
//        xaProp.put("serverName", "localhost");
//        xaProp.put("portNumber", "5432");
        return xaProp;
    }

    @Bean
    public DataSource dataSourceB() {
        try {
            AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
            dataSourceBean.setUniqueResourceName("postgres");
            dataSourceBean.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
            dataSourceBean.setXaProperties(xaBProperties());
            dataSourceBean.setPoolSize(1);
            return dataSourceBean;
        } catch (Exception e) {
            logger.error("DataSource been cannot be created!", e);
            return null;
        }
    }

    @Bean
    public Properties xaBProperties() {
        Properties xaProp = new Properties();
        xaProp.put("databaseName", "gamedb_b");
        xaProp.put("user", "prospring5_b");
        xaProp.put("password", "prospring5");
        xaProp.put("serverName", "localhost");
        xaProp.put("portNumber", "5432");
        return xaProp;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.transaction.factory_class",
                "org.hibernate.transaction.JTATransactionFactory");
        hibernateProp.put("hibernate.transaction.jta.platform",
                "com.atomikos.icatch.jta.hibernate4.AtomikosPlatform");
        // Hibernate 5 required
        hibernateProp.put("hibernate.transaction.coordinator_class", "jta");
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        // Works only if we created schemas before using ddl.sql scripts
        hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
        hibernateProp.put(SHOW_SQL, true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }

    @Bean
    public EntityManagerFactory emfA() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.retrolad.ch09.entities");
        factoryBean.setDataSource(dataSourceA());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName("emfA");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public EntityManagerFactory emfB() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.retrolad.ch09.entities");
        factoryBean.setDataSource(dataSourceB());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName("emfB");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
