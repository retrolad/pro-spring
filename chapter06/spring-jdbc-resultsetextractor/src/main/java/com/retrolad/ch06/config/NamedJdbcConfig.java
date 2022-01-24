package com.retrolad.ch06.config;

import com.retrolad.ch06.JdbcDeveloperDao;
import com.retrolad.ch06.dao.DeveloperDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class NamedJdbcConfig {
    private static Logger logger = LoggerFactory.getLogger(NamedJdbcConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:db/schema.sql", "classpath:db/test-data.sql").build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    @Bean public NamedParameterJdbcTemplate jdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public DeveloperDao singerDao() {
        JdbcDeveloperDao dao = new JdbcDeveloperDao();
        dao.setTemplate(jdbcTemplate());
        return dao;
    }
}
