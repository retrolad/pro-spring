package com.retrolad.ch03.xml;

import com.retrolad.ch03.Oracle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");
        System.out.println(ctx.getBean("injectRef", InjectRef.class));
    }

    @Override
    public String toString() {
        return oracle.getMeaningOfLife();
    }
}
