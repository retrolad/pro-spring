package com.retrolad.ch06;

import com.retrolad.ch06.dao.DeveloperDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        DeveloperDao developerDao = ctx.getBean(DeveloperDao.class);
        System.out.println(developerDao.findNameById(9L));
    }
}
