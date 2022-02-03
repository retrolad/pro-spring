package com.retrolad.ch13.entities;

import java.util.List;

// This class is used to transform list
// of Developer objects to XML or JSON format
public class Developers {

    private List<Developer> developers;

    public Developers() {
    }

    public Developers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
