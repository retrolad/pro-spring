package com.retrolad.ch08;

import com.retrolad.ch08.config.JpaConfig;
import com.retrolad.ch08.service.DeveloperSummaryService;
import com.retrolad.ch08.service.DeveloperSummaryUntypeImpl;
import com.retrolad.ch08.view.DeveloperSummary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DeveloperSummaryJpaTest {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperSummaryJpaTest.class);

    private GenericApplicationContext ctx;
    private DeveloperSummaryService developerSummary;
    private DeveloperSummaryUntypeImpl developerSummaryUntype;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        developerSummaryUntype = ctx.getBean(DeveloperSummaryUntypeImpl.class);
        developerSummary = ctx.getBean(DeveloperSummaryService.class);
        assertNotNull(developerSummaryUntype);
        assertNotNull(developerSummary);
    }

    @Test
    public void testFindAll() {
        List<DeveloperSummary> developers = developerSummary.findAll();
        listDeveloperSummary(developers);
    }

    @Test
    public void testFindAllUntype() {
        developerSummaryUntype.displayAllDeveloperSummary();

    }

    private static void listDeveloperSummary(List<DeveloperSummary> developers) {
        logger.info("---- Listing developers summary");
        developers.forEach(developer -> logger.info(developer.toString()));
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }
}
