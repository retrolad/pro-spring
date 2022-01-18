package com.retrolad.ch03.annotation;

import com.retrolad.ch02.decoupled.MessageProvider;
import com.retrolad.ch02.decoupled.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutputMessageRenderer implements MessageRenderer {
    private MessageProvider provider;

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(@Qualifier("configurableProvider") MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return provider;
    }
}
