package com.retrolad.ch03.annotated;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * When a class implements {@link ApplicationContextAware}, it gets
 * the corresponding {@link ApplicationContext} through setApplicationContext
 * method.
 */
@Component("singer")
@DependsOn("guitar")
public class Singer implements ApplicationContextAware {

    private Guitar guitar;
    ApplicationContext ctx;

    public void sing() {
        guitar = ctx.getBean(Guitar.class);
        guitar.sing();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
