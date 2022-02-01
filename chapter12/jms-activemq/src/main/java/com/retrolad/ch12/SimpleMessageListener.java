package com.retrolad.ch12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service("messageListener")
public class SimpleMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

    @JmsListener(destination = "openwire", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            logger.info(">>> Received: " + textMessage.getText());
        } catch (JMSException e) {
            logger.error("JMS error", e);
        }
    }
}
