package com.retrolad.ch02.decoupled;

public class StandardOutputMessageRenderer implements MessageRenderer{
    MessageProvider provider;

    @Override
    public void render() {
        if(provider == null)
        {
            throw new RuntimeException("You must set the " +
                    "property provider of class:" +
                    StandardOutputMessageRenderer.class.getName());
        }
        System.out.println(provider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return provider;
    }
}
