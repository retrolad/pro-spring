package com.retrolad.ch02.common;

public class Guitar {

    private String brand;

    public String play() {
        return "G C G C Am D7";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
