package com.retrolad.ch06.dao;

import com.retrolad.ch06.entities.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcDeveloperDao implements DeveloperDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
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
        return jdbcTemplate.queryForObject("select name from developer where id=?",
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
    public List<Developer> findAllWithGames() {
        return null;
    }

    @Override
    public void insertWithGames(Developer developer) {

    }
}
