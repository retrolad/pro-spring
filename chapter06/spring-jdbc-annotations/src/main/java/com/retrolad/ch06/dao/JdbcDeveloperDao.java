package com.retrolad.ch06.dao;

import com.retrolad.ch06.InsertDeveloper;
import com.retrolad.ch06.SelectAllDevelopers;
import com.retrolad.ch06.SelectDeveloperByName;
import com.retrolad.ch06.UpdateDeveloper;
import com.retrolad.ch06.entities.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository("developerDao")
public class JdbcDeveloperDao implements DeveloperDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDeveloperDao.class);
    private DataSource dataSource;
    private SelectAllDevelopers selectAllSingers;
    private SelectDeveloperByName selectDeveloperByName;
    private UpdateDeveloper updateDeveloper;
    private InsertDeveloper insertDeveloper;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllDevelopers(dataSource);
        this.selectDeveloperByName = new SelectDeveloperByName(dataSource);
        this.updateDeveloper = new UpdateDeveloper(dataSource);
        this.insertDeveloper = new InsertDeveloper(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<Developer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public List<Developer> findByName(String name) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return selectDeveloperByName.executeByNamedParam(paramMap);
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Developer developer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", developer.getName());
        paramMap.put("founded", developer.getFounded());
        // This retrieves auto generated key
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertDeveloper.updateByNamedParam(paramMap, keyHolder);
        developer.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        logger.info("New developer inserted with id: " + developer.getId());
    }

    @Override
    public void update(Developer developer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", developer.getName());
        paramMap.put("founded", developer.getFounded());
        paramMap.put("id", developer.getId());
        updateDeveloper.updateByNamedParam(paramMap);
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
