package com.retrolad.ch07;

import com.retrolad.ch07.config.AppConfig;
import com.retrolad.ch07.dao.DeveloperDao;
import com.retrolad.ch07.entities.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class SpringHibernateDemo {

    private static final Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        DeveloperDao developerDao = ctx.getBean(DeveloperDao.class);
        List<Developer> developers = developerDao.findAll();

        logger.info("--- Listing developers ---");
        developers.forEach(d -> logger.info(d.toString()));
    }
}
