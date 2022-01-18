package com.retrolad.ch03.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Inspiration {

    private String lyric = "I'm blinded by the lights.";


    public Inspiration(@Value("I can't sleep until I get your touch.") String lyric) {
        this.lyric = lyric;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}
