package com.retrolad.ch06;

import com.retrolad.ch06.config.NamedJdbcConfig;
import com.retrolad.ch06.entities.Developer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ResultSetExtractorTest {

    @Test
    public void testExtractor() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);
        JdbcDeveloperDao developerDao = ctx.getBean(JdbcDeveloperDao.class);
        assertNotNull(developerDao);

        List<Developer> developers = developerDao.findAllWithGames();
        assertEquals(3, developers.size());

        developers.forEach(d -> {
            System.out.println("--- Developer ---");
            System.out.println(d);
            System.out.println("> Games");
            d.getGames().forEach(System.out::println);
        });
    }
}
