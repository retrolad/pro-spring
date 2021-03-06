package com.retrolad.ch08;

import com.retrolad.ch08.config.DataJpaConfig;
import com.retrolad.ch08.entities.Developer;
import com.retrolad.ch08.entities.Game;
import com.retrolad.ch08.services.DeveloperService;
import com.retrolad.ch08.services.GameService;
import com.retrolad.ch08.services.GameServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class DeveloperDataJpaTest {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperDataJpaTest.class);

    private GenericApplicationContext ctx;
    private DeveloperService developerService;
    private GameService gameService;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        developerService = ctx.getBean(DeveloperService.class);
        gameService = ctx.getBean(GameService.class);
        assertNotNull(developerService);
        assertNotNull(gameService);
    }

    @Test
    public void testFindAll() {
        List<Developer> developers = developerService.findAll();
        assertTrue(developers.size() > 0);
        logger.info(developers.toString());
    }

    @Test
    public void testFindAllByName() {
        List<Developer> developers = developerService.findByName("Naughty Dog");
        assertEquals(1, developers.size());
        logger.info(developers.toString());
    }

    @Test
    public void testFindGameByTitle() {
        List<Game> games = gameService.findByTitle("as");
        logger.info(games.toString());
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }
}
