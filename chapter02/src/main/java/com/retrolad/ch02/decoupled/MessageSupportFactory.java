package com.retrolad.ch02.decoupled;

import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties props;
    private MessageProvider provider;
    private MessageRenderer renderer;

    static {
        instance = new MessageSupportFactory();
    }

    public MessageSupportFactory() {
        props = new Properties();

        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));

            String providerClass = props.getProperty("provider.class");
            String rendererClass = props.getProperty("renderer.class");

            provider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
            renderer = (MessageRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageProvider getProvider() {
        return provider;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }
}
