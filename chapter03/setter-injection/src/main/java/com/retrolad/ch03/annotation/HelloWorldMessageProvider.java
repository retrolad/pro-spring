package com.retrolad.ch03.annotation;

import com.retrolad.ch02.decoupled.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello, chapter03!";
    }
}
