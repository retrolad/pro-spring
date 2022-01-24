package com.retrolad.ch06.config;

import com.retrolad.ch06.JdbcDeveloperDao;
import com.retrolad.ch06.dao.DeveloperDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class EmbeddedJdbcConfig {

    private static Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:db/h2/schema.sql", "classpath:db/h2/test-data.sql")
                    .build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created.", e);
            return null;
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DataSource dataSource = dataSource();
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DeveloperDao developerDao() {
        JdbcDeveloperDao dao = new JdbcDeveloperDao();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
