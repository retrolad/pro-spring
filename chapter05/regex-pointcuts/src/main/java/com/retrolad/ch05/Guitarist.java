package com.retrolad.ch05;

import com.retrolad.ch02.common.Singer;

public class Guitarist implements Singer {

    public void sing() {
        System.out.println("Oh, Californian dreamin' On such a winter's day.");
    }

    public void sing2() {
        System.out.println("UUuuuuuuuu I'm blinded by the liiiights, I can't sleep until I feel your touch.");
    }

    public void rest() {
        System.out.println("Zzz");
    }
}
