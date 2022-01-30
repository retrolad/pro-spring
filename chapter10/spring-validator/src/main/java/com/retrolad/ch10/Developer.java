package com.retrolad.ch10;

import org.joda.time.DateTime;

import java.net.URL;

public class Developer {

    private String name;
    private DateTime foundingTime;
    private URL url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(DateTime foundingTime) {
        this.foundingTime = foundingTime;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
