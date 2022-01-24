package com.retrolad.ch06;

import com.retrolad.ch06.config.EmbeddedJdbcConfig;
import com.retrolad.ch06.dao.DeveloperDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class JdbcCfgTest {

    @Test
    public void testH2DB() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        DeveloperDao developerDao = ctx.getBean(DeveloperDao.class);
        assertNotNull(developerDao);

        String developerName = developerDao.findNameById(1L);
        assertEquals("CD PROJEKT RED", developerName);
    }
}
