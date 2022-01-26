package com.retrolad.ch07;

import com.retrolad.ch07.config.AppConfig;
import com.retrolad.ch07.dao.DeveloperDao;
import com.retrolad.ch07.dao.DeveloperDaoImpl;
import com.retrolad.ch07.entities.Developer;
import com.retrolad.ch07.entities.Game;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNotNull;

public class DeveloperDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperDaoTest.class);

    private GenericApplicationContext ctx;
    private DeveloperDao developerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        developerDao = ctx.getBean(DeveloperDao.class);
        assertNotNull(developerDao);
    }

    @Test
    public void testSave() {
        Developer developer = new Developer();
        developer.setName("Ubisoft");
        developer.setFounded(new Date(
                new GregorianCalendar(1986, Calendar.MARCH, 28)
                        .getTime().getTime()));
        Game game = new Game();
        game.setTitle("Far Cry 3");
        game.setReleaseDate(new Date(
                new GregorianCalendar(2012, Calendar.NOVEMBER, 12)
                        .getTime().getTime()));
        developer.addGame(game);

        developerDao.save(developer);
        assertNotNull(developer.getId());
    }
}
