package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import com.retrolad.ch02.common.Singer;

public class Guitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("Ground control to Major Tom...");
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("Zzz");
    }
}
