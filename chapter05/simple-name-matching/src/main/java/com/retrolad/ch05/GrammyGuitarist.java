package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import com.retrolad.ch02.common.Singer;

public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Ground Control To Major Tom...");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("Zzz");
    }

    public void talk() {
        System.out.println("Blah");
    }
}
