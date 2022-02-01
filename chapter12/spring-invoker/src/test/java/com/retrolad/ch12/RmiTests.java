package com.retrolad.ch12;

import com.retrolad.ch12.config.RmiClientConfig;
import com.retrolad.ch12.entities.Developer;
import com.retrolad.ch12.services.DeveloperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = RmiClientConfig.class)
@RunWith(SpringRunner.class)
public class RmiTests {

    private static final Logger logger = LoggerFactory.getLogger(RmiTests.class);

    @Autowired
    private DeveloperService developerService;

    @Test
    public void testRmiAll() {
        List<Developer> developers = developerService.findAll();
        assertEquals(2, developers.size());
        developers.forEach(developer -> logger.info(developer.toString()));
    }

    @Test
    public void testRmiFindByName() {
        List<Developer> developers = developerService.findByName("EA");
        assertEquals(1, developers.size());
        developers.forEach(developer -> logger.info(developer.toString()));
    }
}
