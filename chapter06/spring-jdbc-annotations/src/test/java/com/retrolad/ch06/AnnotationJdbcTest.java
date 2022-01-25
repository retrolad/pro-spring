package com.retrolad.ch06;

import com.retrolad.ch06.config.DbConfig;
import com.retrolad.ch06.dao.JdbcDeveloperDao;
import com.retrolad.ch06.entities.Developer;
import com.retrolad.ch06.entities.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class AnnotationJdbcTest {

    private GenericApplicationContext ctx;
    private JdbcDeveloperDao developerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        developerDao = ctx.getBean(JdbcDeveloperDao.class);
        assertNotNull(developerDao);
    }

    @Test
    public void testFindAll() {
        List<Developer> developers = developerDao.findAll();
        developers.forEach(System.out::println);
    }

    @Test
    public void testFindByName() {
        List<Developer> developers = developerDao.findByName("Bethesda Softworks");
        assertEquals(1, developers.size());
        listDevelopers(developers);
    }

    @Test
    public void testSingerUpdate() {
        Developer developer = new Developer();
        developer.setId(3L);
        developer.setName("id Software");
        developer.setFounded(new Date(new GregorianCalendar(1991, Calendar.FEBRUARY, 3).getTime().getTime()));
        developerDao.update(developer);

        List<Developer> developers = developerDao.findAll();
        listDevelopers(developers);
    }

    @Test
    public void testDeveloperInsert() {
        Developer developer = new Developer();
        developer.setName("Electronic Arts");
        developer.setFounded(new Date(new GregorianCalendar(1993, Calendar.JANUARY, 5).getTime().getTime()));
        developerDao.insert(developer);

        listDevelopers(developerDao.findAll());
    }

    @Test
    public void testInsertWithGames() {
        Developer developer = new Developer();
        developer.setName("Naughty Dogs");
        developer.setFounded(new Date(new GregorianCalendar(1994, Calendar.MARCH, 7).getTime().getTime()));
        developer.setGames(new ArrayList<>());

        Game game = new Game();
        game.setTitle("The Last Of Us");
        game.setReleaseDate(new Date(new GregorianCalendar(2013, Calendar.JUNE, 15).getTime().getTime()));
        developer.addGame(game);

        Game game2 = new Game();
        game2.setTitle("Uncharted 4");
        game2.setReleaseDate(new Date(new GregorianCalendar(2016, Calendar.MAY, 18).getTime().getTime()));
        developer.addGame(game2);

        developerDao.insertWithGames(developer);

        listDevelopers(developerDao.findAllWithGames());
    }

    public void listDevelopers(List<Developer> developers) {
        developers.forEach(developer -> {
            System.out.println(developer);
            if(developer.getGames() != null) {
                developer.getGames().forEach(game -> System.out.println("\t--> " + game));
            }
        });

    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
