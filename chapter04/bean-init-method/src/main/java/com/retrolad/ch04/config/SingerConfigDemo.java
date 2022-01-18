package com.retrolad.ch04.config;

import com.retrolad.ch04.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class SingerConfigDemo {

    @Configuration
    static class SingerConfig {

        @Lazy
        @Bean(initMethod = "init")
        Singer singerOne() {
            Singer singer = new Singer();
            singer.setName("David Gahan");
            singer.setAge(59);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo() {
            Singer singer = new Singer();
            singer.setName("Steven Tyler");
            return singer;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
    }

    public static Singer getBean(String beanName, ApplicationContext ctx) {
        try {
            Singer singer = ctx.getBean(beanName, Singer.class);
            System.out.println(singer);
            return singer;
        } catch(BeanCreationException ex) {
            System.out.println("An error occurred in bean " +
                    "configuration: " + ex.getMessage());
            return null;
        }
    }
}
