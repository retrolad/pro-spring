package com.retrolad.ch06;

import com.retrolad.ch06.dao.DeveloperDao;
import com.retrolad.ch06.entities.Developer;
import com.retrolad.ch06.entities.Game;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Developer> findAllWithGames() {

        String sql = "select d.id, d.name, d.founded, g.id as game_id, g.title, g.release_date from developer d left join game g on d.id = g.developer_id";
        return template.query(sql, (rs -> {
            Map<Long, Developer> map = new HashMap<>();

            while(rs.next()) {

                Long id = rs.getLong("id");
                Developer developer = map.get(id);
                if(developer == null) {
                    developer = new Developer();
                    developer.setId(id);
                    developer.setName(rs.getString("name"));
                    developer.setFounded(rs.getDate("founded"));
                    developer.setGames(new ArrayList<>());
                    map.put(id, developer);
                }

                Long gameId = rs.getLong("game_id");
                if(gameId > 0) {
                    Game game = new Game();
                    game.setId(gameId);
                    game.setDeveloperId(id);
                    game.setTitle(rs.getString("title"));
                    game.setReleaseDate(rs.getDate("release_date"));
                    developer.addGame(game);
                }
            }

            return new ArrayList<>(map.values());
        }));
    }

    @Override
    public void insertWithGames(Developer developer) {

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
