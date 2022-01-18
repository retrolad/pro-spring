package com.retrolad.ch02.decoupled;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello, Worldd!";
    }
}
