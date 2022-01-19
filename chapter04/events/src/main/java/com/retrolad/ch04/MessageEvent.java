package com.retrolad.ch04;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

    String message;

    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
