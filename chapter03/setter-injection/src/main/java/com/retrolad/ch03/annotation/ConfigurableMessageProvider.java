package com.retrolad.ch03.annotation;

import com.retrolad.ch02.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("configurableProvider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(@Value("Configurable Message") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
