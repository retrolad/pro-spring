package com.retrolad.ch03.annotation;

import com.retrolad.ch02.decoupled.MessageProvider;
import com.retrolad.ch02.decoupled.MessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = "spring/app-context-annotation-xml.xml")

@ComponentScan(basePackages = "com.retrolad.ch03.annotation")
@Configuration
public class HelloWorldConfiguration {

//    @Bean
//    public MessageProvider provider() {
//        return new HelloWorldMessageProvider();
//    }
//
//    @Bean
//    public MessageRenderer renderer() {
//        return new StandardOutputMessageRenderer();
//    }
}
