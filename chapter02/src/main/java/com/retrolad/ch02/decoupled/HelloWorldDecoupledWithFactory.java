package com.retrolad.ch02.decoupled;

public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageSupportFactory factory = MessageSupportFactory.getInstance();

        MessageProvider provider = factory.getProvider();
        MessageRenderer renderer = factory.getRenderer();

        renderer.setMessageProvider(provider);
        renderer.render();
    }
}
