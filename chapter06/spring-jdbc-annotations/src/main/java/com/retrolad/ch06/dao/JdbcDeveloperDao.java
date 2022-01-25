package com.retrolad.ch06.dao;

import com.retrolad.ch06.*;
import com.retrolad.ch06.entities.Developer;
import com.retrolad.ch06.entities.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.*;

@Repository("developerDao")
public class JdbcDeveloperDao implements DeveloperDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDeveloperDao.class);
    private DataSource dataSource;
    private SelectAllDevelopers selectAllSingers;
    private SelectDeveloperByName selectDeveloperByName;
    private UpdateDeveloper updateDeveloper;
    private InsertDeveloper insertDeveloper;
    private InsertDeveloperGame insertDeveloperGame;
    private StoredFunctionNameById storedFunctionNameById;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllDevelopers(dataSource);
        this.selectDeveloperByName = new SelectDeveloperByName(dataSource);
        this.updateDeveloper = new UpdateDeveloper(dataSource);
        this.insertDeveloper = new InsertDeveloper(dataSource);
        this.storedFunctionNameById = new StoredFunctionNameById(dataSource);
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
        return storedFunctionNameById.execute(id).get(0);
    }

    @Override
    public Long insert(Developer developer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", developer.getName());
        paramMap.put("founded", developer.getFounded());
        // This retrieves auto generated key
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertDeveloper.updateByNamedParam(paramMap, keyHolder);
        developer.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        logger.info("New developer inserted with id: " + developer.getId());

        return developer.getId();
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
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "select d.id, d.name, d.founded, g.id as game_id, g.title, g.release_date " +
                "from developer d left join game g on g.developer_id=d.id";
        return jdbcTemplate.query(sql, rs -> {
            Map<Long, Developer> developersWithGames = new HashMap<>();

            while(rs.next()) {
                Long id = rs.getLong("id");
                Developer developer = developersWithGames.get(id);
                if(developer == null) {
                    developer = new Developer();
                    developer.setId(rs.getLong("id"));
                    developer.setName(rs.getString("name"));
                    developer.setFounded(rs.getDate("founded"));
                    developer.setGames(new ArrayList<>());
                }

                Long gameId = rs.getLong("game_id");
                if(gameId > 0) {
                    Game game = new Game();
                    game.setId(gameId);
                    game.setTitle(rs.getString("title"));
                    game.setReleaseDate(rs.getDate("release_date"));
                    developer.addGame(game);
                }

                developersWithGames.put(id, developer);
            }

            return new ArrayList<>(developersWithGames.values());
        });
    }

    @Override
    public void insertWithGames(Developer developer) {
        // For every operation create new instance of InsertDeveloperGame
        // since BatchSqlUpdate is not thread safe
        this.insertDeveloperGame = new InsertDeveloperGame(dataSource);
        Long developerId = insert(developer);
        List<Game> games = developer.getGames();
        Map<String, Object> paramMap;

        if(games != null) {
            for(Game game : games) {
                paramMap = new HashMap<>();
                paramMap.put("title", game.getTitle());
                paramMap.put("developer_id", developerId);
                paramMap.put("release_date", game.getReleaseDate());
                insertDeveloperGame.updateByNamedParam(paramMap);
            }
        }
        // Force batch update, if there are < BATCH_SIZE games
        // in the queue
        insertDeveloperGame.flush();
    }
}
