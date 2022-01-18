package com.retrolad.ch03;

import com.retrolad.ch02.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");
        MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
