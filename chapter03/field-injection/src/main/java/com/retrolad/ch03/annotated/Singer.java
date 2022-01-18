package com.retrolad.ch03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Singer {

    @Autowired
    private Inspiration inspirationBean;

    public void sing() {
        System.out.println("..." + inspirationBean.getLyric());
    }
}
