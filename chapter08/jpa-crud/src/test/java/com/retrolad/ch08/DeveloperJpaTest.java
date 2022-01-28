package com.retrolad.ch08;

import com.retrolad.ch08.config.JpaConfig;
import com.retrolad.ch08.entities.City;
import com.retrolad.ch08.entities.Developer;
import com.retrolad.ch08.entities.Game;
import com.retrolad.ch08.service.DeveloperService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeveloperJpaTest {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperJpaTest.class);

    private GenericApplicationContext ctx;
    private DeveloperService developerService;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        developerService = ctx.getBean(DeveloperService.class);
        assertNotNull(developerService);
    }

    @Test
    public void testFindAll() {
        List<Developer> developers = developerService.findAll();
        assertEquals(5, developers.size());
        listDevelopers(developers);
    }

    @Test
    public void testFindAllWithGame() {
        List<Developer> developers = developerService.findAllWithAlbum();
        assertEquals(5, developers.size());
        listDevelopersWithGame(developers);
    }

    private static void listDevelopers(List<Developer> developers) {
        logger.info("---- Listing developers");
        developers.forEach(developer -> logger.info(developer.toString()));
    }

    private static void listDevelopersWithGame(List<Developer> developers) {
        logger.info("---- Listing developers");
        developers.forEach(developer -> {
            logger.info(developer.toString());
            for (Game game : developer.getGames()) {
                logger.info(game.toString());
            }
            for (City city : developer.getCities()) {
                logger.info(city.toString());
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }
}
