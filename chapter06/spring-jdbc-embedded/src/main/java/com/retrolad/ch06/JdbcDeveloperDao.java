package com.retrolad.ch06;

import com.retrolad.ch06.dao.DeveloperDao;
import com.retrolad.ch06.entities.Developer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcDeveloperDao implements DeveloperDao, InitializingBean {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Developer> findAll() {
        return null;
    }

    @Override
    public List<Developer> findByName(String firstName) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject("select name from developer where id = ?",
                String.class, id);
    }

    @Override
    public void insert(Developer developer) {

    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(Long developerId) {

    }

    @Override
    public List<Developer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Developer developer) {

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if(jdbcTemplate == null) {
            throw new BeanCreationException("Nul jdbcTemplate on DeveloperDao");
        }
    }

}