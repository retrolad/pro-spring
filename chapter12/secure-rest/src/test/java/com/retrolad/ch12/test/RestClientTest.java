package com.retrolad.ch12.test;

import com.retrolad.ch12.RestClientConfig;
import com.retrolad.ch12.entities.Developer;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.sql.ClientInfoStatus;
import java.util.List;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestClientConfig.class})
public class RestClientTest {

    private static final Logger logger = LoggerFactory.getLogger(RestClientTest.class);
    private static final String URL_GET_ALL_DEVELOPERS = "http://localhost:8080/rest/developer/listdata";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testFindAll() {
        logger.info("--> Testing retrieve all developers");
        List<Developer> developers = restTemplate.getForObject(URL_GET_ALL_DEVELOPERS, List.class);
        developers.forEach(d -> logger.info(d.toString()));
    }
}
