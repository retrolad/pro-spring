package com.retrolad.ch10.obj;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Developer {

    @NotNull
    @Size(min=2, max=60)
    private String name;

    @NotNull
    private Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
