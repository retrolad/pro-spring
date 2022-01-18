package com.retrolad.ch03;

public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
