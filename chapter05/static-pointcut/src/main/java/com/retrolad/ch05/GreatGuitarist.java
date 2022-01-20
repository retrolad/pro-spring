package com.retrolad.ch05;

import com.retrolad.ch02.common.Singer;

public class GreatGuitarist implements Singer {

    private String lyric = "The GREATEST guitarist of all time!!!";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
