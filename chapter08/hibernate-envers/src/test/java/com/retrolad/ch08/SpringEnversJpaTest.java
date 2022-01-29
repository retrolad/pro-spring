package com.retrolad.ch08;

import com.retrolad.ch08.config.EnversConfig;
import com.retrolad.ch08.entities.DeveloperAudit;
import com.retrolad.ch08.services.DeveloperAuditService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SpringEnversJpaTest {

    private static final Logger logger = LoggerFactory.getLogger(SpringEnversJpaTest.class);

    private GenericApplicationContext ctx;
    private DeveloperAuditService developerAuditService;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext(EnversConfig.class);
        developerAuditService = ctx.getBean(DeveloperAuditService.class);
        assertNotNull(developerAuditService);
    }

    @Test
    public void testRevision() {
        logger.info("Add new developer");
        DeveloperAudit developerAudit = new DeveloperAudit();
        developerAudit.setName("Bethesda Softworks");
        developerAudit.setFounded(new Date(new GregorianCalendar(1986, Calendar.FEBRUARY, 19).getTime().getTime()));
        developerAuditService.save(developerAudit);
        listDevelopers(developerAuditService.findAll());

        logger.info("Update developer");
        developerAudit.setName("Bethesda Shitworks");
        developerAuditService.save(developerAudit);
        listDevelopers(developerAuditService.findAll());

        DeveloperAudit oldDeveloper = developerAuditService.findAuditByRevision(1L, 1);
        logger.info("");
        logger.info("Developer with id 1 and revision 1: " + oldDeveloper.toString());
        logger.info("");
        oldDeveloper = developerAuditService.findAuditByRevision(1L, 2);
        logger.info("");
        logger.info("Developer with id 1 and revision 2: " + oldDeveloper.toString());
        logger.info("");
    }

    private static void listDevelopers(List<DeveloperAudit> developers) {
        developers.forEach(d -> logger.info(d.toString()));
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }
}
