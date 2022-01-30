package com.retrolad.ch10.obj;

import com.retrolad.ch10.CheckFpsDeveloper;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@CheckFpsDeveloper
public class Developer {

    @NotNull
    @Size(min = 2, max = 60)
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

    public boolean isFpsDeveloper() {
        return genre == Genre.FPS;
    }

    // Alternative way to define custom validator
//    @AssertTrue(message = "ERROR! Developer should have name defined")
//    public boolean isFpsDeveloper() {
//        boolean isValid = true;
//        if (genre != null && genre.equals(Genre.FPS) && name == null) {
//            isValid = false;
//        }
//        return isValid;
//    }
}