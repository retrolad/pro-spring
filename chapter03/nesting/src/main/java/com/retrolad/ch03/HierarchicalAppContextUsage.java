package com.retrolad.ch03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parentCtx = new GenericXmlApplicationContext("classpath:spring/parent-context.xml");

        GenericXmlApplicationContext childCtx = new GenericXmlApplicationContext("classpath:spring/child-context.xml");
        childCtx.setParent(parentCtx);

        System.out.println(childCtx.getBean("song1", Song.class).getTitle());
        System.out.println(childCtx.getBean("song2", Song.class).getTitle());
        System.out.println(childCtx.getBean("song3", Song.class).getTitle());

        childCtx.close();
        parentCtx.close();
    }
}
