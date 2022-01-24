package com.retrolad.ch06;

import com.retrolad.ch06.dao.DeveloperDao;
import com.retrolad.ch06.entities.Developer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperDao implements DeveloperDao, InitializingBean {

    private NamedParameterJdbcTemplate template;

    @Override
    public List<Developer> findAll() {
        String sql = "select * from developer";
        return template.query(sql, (rs, rowNum) -> {
            {
                Developer developer = new Developer();
                developer.setId(rs.getLong("id"));
                developer.setName(rs.getString("name"));
                developer.setFounded(rs.getDate("founded"));

                return developer;
            }
        });
    }

    @Override
    public List<Developer> findByName(String firstName) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
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
        if(template == null) {
            throw new BeanCreationException("Null template on DeveloperDao");
        }
    }

    public void setTemplate(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

}
