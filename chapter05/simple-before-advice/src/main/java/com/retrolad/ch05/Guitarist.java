package com.retrolad.ch05;

import com.retrolad.ch02.common.Singer;

public class Guitarist implements Singer {

    private String lyric = "Show must go on!";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
