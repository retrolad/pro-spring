package com.retrolad.ch10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.ConversionService;

public class ConvFormatSevDemo {

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Developer developer = ctx.getBean(Developer.class);
        System.out.println("Developer: " + developer);
        ConversionService conversionService = ctx.getBean(ConversionService.class);
        System.out.println("Founded: " + conversionService.convert(developer.getFoundingTime(), String.class));
    }
}
