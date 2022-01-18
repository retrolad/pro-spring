package com.retrolad.ch03.annotated;

import org.springframework.stereotype.Component;

@Component("guitar")
public class Guitar {

    public void sing() {
        System.out.println("Lalala");
    }
}
