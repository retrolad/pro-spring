package com.retrolad.ch03.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
public class Singer {

    private String lyric = "А снится нам не рокот космодрома!";

    public void sing() {
        //System.out.println(lyric);
    }
}
