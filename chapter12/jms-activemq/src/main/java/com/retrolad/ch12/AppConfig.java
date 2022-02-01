package com.retrolad.ch12;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.apache.activemq.artemis.core.remoting.impl.netty.TransportConstants;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
@ComponentScan(basePackages = "com.retrolad.ch12")
public class AppConfig {

    // Artemis implementation of a JMS queue
    @Bean
    ActiveMQQueue prospring5() {
        return new ActiveMQQueue("");
    }

    @Bean
    ConnectionFactory connectionFactory() {
        Map<String, Object> connDetails = new HashMap<>();
        connDetails.put(TransportConstants.HOST_PROP_NAME, "0.0.0.0");
        connDetails.put(TransportConstants.PORT_PROP_NAME, "61616");
        connDetails.put(TransportConstants.PROTOCOLS_PROP_NAME, "tcp");
        TransportConfiguration transportConfiguration = new TransportConfiguration(
                NettyConnectorFactory.class.getName(), connDetails
        );
        return new ActiveMQConnectionFactory(false, transportConfiguration);
    }

    // JmsListener needs a connection factory
    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }

    @Bean
    JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestination(prospring5());
        return jmsTemplate;
    }
}
