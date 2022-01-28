package com.retrolad.ch08.view;

import java.io.Serializable;
import java.util.Date;

public class DeveloperSummary implements Serializable {

    private String developerName;
    private String gameTitle;
    private Date gameReleaseDate;

    public DeveloperSummary(String developerName, String gameTitle, Date gameReleaseDate) {
        this.developerName = developerName;
        this.gameTitle = gameTitle;
        this.gameReleaseDate = gameReleaseDate;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public Date getGameReleaseDate() {
        return gameReleaseDate;
    }

    @Override
    public String toString() {
        return "SingerSummary{" +
                "developerName='" + developerName + '\'' +
                ", gameTitle='" + gameTitle + '\'' +
                ", gameReleaseDate=" + gameReleaseDate +
                '}';
    }
}
