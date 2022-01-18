package com.retrolad.ch04;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithInterface implements InitializingBean {
    private static final String DEFAULT_NAME = "Abel Makkonen Tesfaye";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void afterPropertiesSet() {
        System.out.println("Initializing bean");

        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property" +
                    "of any bean of type " + SingerWithInterface.class);
        }
    }

    @Override
    public String toString() {
        return "SingerWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context.xml");

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static SingerWithInterface getBean(String beanName, ApplicationContext ctx) {
        try {
            SingerWithInterface singer = ctx.getBean(beanName, SingerWithInterface.class);
            System.out.println(singer);
            return singer;
        } catch(BeanCreationException ex) {
            System.out.println("An error occurred in bean " +
                    "configuration: " + ex.getMessage());
            return null;
        }
    }
}
