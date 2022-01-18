package com.retrolad.ch03.annotated;

import org.springframework.stereotype.Service;

@Service("lyricHolder")
public class LyricHolder {

    private String lyric = "UUUuuuu I'M BLINDED BY THE LIIIIGHTS";

    @Override
    public String toString() {
        return "LyricHolder{" +
                "lyric='" + lyric + '\'' +
                '}';
    }
}
