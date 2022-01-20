package com.retrolad.ch05;

import com.retrolad.ch02.common.Singer;

public class GoodGuitarist implements Singer {

    private String lyric = "I'm a GOOD guitarist.";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
