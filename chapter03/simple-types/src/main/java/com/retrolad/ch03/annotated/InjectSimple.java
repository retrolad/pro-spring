package com.retrolad.ch03.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {

    @Value("Jadon Sancho")
    private String name;
    @Value("21")
    private int age;
    @Value("1.80")
    private float height;
    @Value("false")
    private boolean programmer;
    @Value("2123145112")
    private Long ageInSeconds;

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation.xml");
        System.out.println(ctx.getBean("injectSimple"));
    }

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
