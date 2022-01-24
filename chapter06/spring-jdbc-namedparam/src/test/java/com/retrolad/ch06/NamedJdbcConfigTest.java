package com.retrolad.ch06;

import com.retrolad.ch06.config.NamedJdbcConfig;
import com.retrolad.ch06.dao.DeveloperDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class NamedJdbcConfigTest {

    @Test
    public void testNamedCfg() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);
        DeveloperDao developerDao = ctx.getBean(DeveloperDao.class);
        assertNotNull(developerDao);

        String developerName = developerDao.findNameById(2L);
        assertEquals("Bethesda Softworks", developerName);
    }
}
