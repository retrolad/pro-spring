package com.retrolad.ch10.obj;

public enum Genre {
    RPG("RPG"),
    FPS("FPS"),
    RTS("RTS");

    private String code;

    private Genre(String code) {
        this.code = code;
    }
}
