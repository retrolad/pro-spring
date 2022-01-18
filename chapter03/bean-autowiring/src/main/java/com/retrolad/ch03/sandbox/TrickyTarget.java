package com.retrolad.ch03.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrickyTarget {

    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget() {
    }

    public TrickyTarget(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("TrickyTarget(Foo) constructor");
    }

    public TrickyTarget(Foo fooOne, Bar bar) {
        this.fooTwo = fooOne;
        this.bar = bar;
        System.out.println("TrickyTarget(Foo, Bar) constructor");
    }

    @Autowired
//    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    @Autowired
//    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-03.xml");
        ctx.getBean(TrickyTarget.class);
    }
}
