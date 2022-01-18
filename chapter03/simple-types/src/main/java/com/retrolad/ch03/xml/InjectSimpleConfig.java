package com.retrolad.ch03.xml;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {

    private String name = "Axel Tuanzebe";
    private int age = 24;
    private float height = 1.85f;
    private boolean programmer = false;
    private Long ageInSeconds = 1241251323L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
