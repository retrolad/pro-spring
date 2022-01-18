package com.retrolad.ch02.annotated;

import com.retrolad.ch02.decoupled.HelloWorldMessageProvider;
import com.retrolad.ch02.decoupled.MessageProvider;
import com.retrolad.ch02.decoupled.MessageRenderer;
import com.retrolad.ch02.decoupled.StandardOutputMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new StandardOutputMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
