package com.retrolad.ch04;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Publisher implements ApplicationContextAware {

    @Configuration
    public static class MessageEventConfig {

        @Bean
        public Publisher getPublisher() {
            return new Publisher();
        }

        @Bean
        public MessageEventListener getMessageEventListener() {
            return new MessageEventListener();
        }
    }

    ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MessageEventConfig.class);
        Publisher publisher = ctx.getBean(Publisher.class);
        publisher.publish("THIS IS THE BEST EVENT");
    }
}
