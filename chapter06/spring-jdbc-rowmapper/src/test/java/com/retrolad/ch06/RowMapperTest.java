package com.retrolad.ch06;

import com.retrolad.ch06.config.NamedJdbcConfig;
import com.retrolad.ch06.entities.Developer;
import com.retrolad.ch06.entities.Game;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class RowMapperTest {

    @Test
    public void testMapper() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);
        JdbcDeveloperDao developerDao = ctx.getBean(JdbcDeveloperDao.class);
        assertNotNull(developerDao);

        List<Developer> developers = developerDao.findAll();
        assertEquals(3, developers.size());

        developers.forEach(developer -> {
            System.out.println(developer);
            if(developer.getGames() != null) {
                for(Game game : developer.getGames()) {
                    System.out.println("----" + game);
                }
            }
        });
    }
}
