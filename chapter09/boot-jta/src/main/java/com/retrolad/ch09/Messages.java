package com.retrolad.ch09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// Spring components for message interception
@Component
public class Messages {

    private static final Logger logger = LoggerFactory.getLogger(Messages.class);

    @JmsListener(destination = "developers")
    public void onMessage(String content) {
        logger.info("--> Received content: " + content);
    }
}
