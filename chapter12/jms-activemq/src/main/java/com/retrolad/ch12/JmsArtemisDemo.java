package com.retrolad.ch12;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class JmsArtemisDemo {

    public static void main(String[] args) throws IOException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = ctx.getBean(MessageSender.class);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
        for (int i = 0; i < 10; i++) {
            messageSender.sendMessage("Test message: " + i);
        }
        System.in.read();
        ctx.close();
    }
}
