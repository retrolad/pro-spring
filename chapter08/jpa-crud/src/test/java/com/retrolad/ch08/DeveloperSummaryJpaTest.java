package com.retrolad.ch08;

import com.retrolad.ch08.config.JpaConfig;
import com.retrolad.ch08.service.DeveloperSummaryUntypeImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.Assert.assertNotNull;

public class DeveloperSummaryJpaTest {

    private GenericApplicationContext ctx;
    private DeveloperSummaryUntypeImpl developerSummaryUntype;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        developerSummaryUntype = ctx.getBean(DeveloperSummaryUntypeImpl.class);
        assertNotNull(developerSummaryUntype);
    }

    @Test
    public void testFindAllUntype() {
        developerSummaryUntype.displayAllDeveloperSummary();
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }
}
