package com.retrolad.ch06;

import com.retrolad.ch06.dao.DeveloperDao;
import com.retrolad.ch06.dao.PlainDeveloperDao;
import com.retrolad.ch06.entities.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.sql.Date;

public class PlainJdbcDemo {

    private static DeveloperDao developerDao = new PlainDeveloperDao();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        logger.info("Listing initial developer data:");
//        System.out.println("Listing initial developer data:");
        listAllDevelopers();
        logger.info(("-------------"));
        logger.info("Insert a new developer");

        Developer developer = new Developer();
        developer.setName("Electronic Arts");
        developer.setFounded(new Date(new GregorianCalendar(1991, Calendar.FEBRUARY, 19).getTime().getTime()));
        developerDao.insert(developer);

        logger.info("Listing developer data after new developer created");

        listAllDevelopers();

        logger.info(("-------------"));
        logger.info("Deleting the previous created developer");
        developerDao.delete(developer.getId());
        logger.info("Listing developer data after new developer deleted");

        listAllDevelopers();
    }

    public static void listAllDevelopers() {
        List<Developer> developers = null;
        developers = developerDao.findAll();
        for(Developer developer : developers) {
            logger.info(developer.toString());
//            System.out.println(developer);
        }
    }
}
