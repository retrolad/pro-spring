package com.retrolad.ch03;

public class StandardLookupDemoBean implements DemoBean {

    private Singer singer;

    @Override
    public Singer getMySinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
