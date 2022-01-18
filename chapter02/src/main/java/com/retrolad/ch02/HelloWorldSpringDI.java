package com.retrolad.ch02;

import com.retrolad.ch02.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.CompositeName;
import javax.naming.InvalidNameException;
import javax.naming.Name;
import java.util.Enumeration;

public class HelloWorldSpringDI {
    public static void main(String[] args) throws InvalidNameException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");

        MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
