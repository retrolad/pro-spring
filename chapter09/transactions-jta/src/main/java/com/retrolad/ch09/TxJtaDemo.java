package com.retrolad.ch09;

import com.retrolad.ch09.config.ServicesConfig;
import com.retrolad.ch09.config.XAJpaConfig;
import com.retrolad.ch09.entities.Developer;
import com.retrolad.ch09.services.DeveloperService;
import com.retrolad.ch09.services.DeveloperServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TxJtaDemo {

    private static final Logger logger = LoggerFactory.getLogger(TxJtaDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(
                ServicesConfig.class, XAJpaConfig.class
        );

        DeveloperService developerService = ctx.getBean(DeveloperService.class);
        Developer developer = new Developer();
        developer.setName("Bethesda");
        developer.setFounded(new Date(new GregorianCalendar(1986, Calendar.FEBRUARY, 14).getTime().getTime()));

        developerService.save(developer);
        if(developer.getId() != null) {
            logger.info("---> Developer was saved successfully");
        } else {
            logger.info("---> Developer was not saved!");
        }
    }
}
