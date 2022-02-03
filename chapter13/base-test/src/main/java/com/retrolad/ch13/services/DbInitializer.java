package com.retrolad.ch13.services;

import com.retrolad.ch13.entities.Developer;
import com.retrolad.ch13.repos.DeveloperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class DbInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    @Autowired
    private DeveloperRepository developerRepository;

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");
        Developer developer = new Developer();
        developer.setName("Ubisoft");
        developer.setFounded(new Date(
                new GregorianCalendar(1992, Calendar.MARCH, 28)
                        .getTime().getTime()));

        developerRepository.save(developer);

        developer = new Developer();
        developer.setName("EA");
        developer.setFounded(new Date(
                new GregorianCalendar(1986, Calendar.MARCH, 30)
                        .getTime().getTime()));

        developerRepository.save(developer);
    }
}
