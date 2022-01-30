package com.retrolad.ch09;

import com.retrolad.ch09.entities.Developer;
import com.retrolad.ch09.services.DeveloperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication(scanBasePackages = "com.retrolad.ch09.services")
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    DeveloperService developerService;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.in.read();
        ctx.close();
    }

    @Override
    public void run(String... args) throws Exception {
        Developer developer = new Developer();
        developer.setName("Bethesda");
        developer.setFounded(new Date(new GregorianCalendar(1986, Calendar.FEBRUARY, 14).getTime().getTime()));
        developerService.save(developer);

//        long count = developerService.count();
//        if(count == 1) {
//            logger.info("--> Developer saved successfully");
//        } else {
//            logger.error("--> Developer was not saved");
//        }
//
//        try {
//            developerService.save(null);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), "Final count: " + developerService.count());
//        }
    }
}
