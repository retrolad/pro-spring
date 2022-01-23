package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import com.retrolad.ch02.common.Singer;
import org.springframework.stereotype.Component;

@Component("johnMayer")
public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("UUuuuu I'm blinded by the liiiights");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void talk() {
        System.out.println("Stop talking, get to work!");
    }
}
