package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import com.retrolad.ch02.common.Singer;

public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Ground control to Major Tom...");
    }

    public void talk() {
        System.out.println("Stop talking, get to work!");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }
}
