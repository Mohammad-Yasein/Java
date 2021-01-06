package com.assignments.dojosurvey.models;

public class Survey {
    private String username;
    private String location;
    private String fav_language;
    private String comment;

    public Survey() {
    }

    public Survey(String username, String location, String fav_language, String comment) {
        this.username = username;
        this.location = location;
        this.fav_language = fav_language;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFav_language() {
        return fav_language;
    }

    public void setFav_language(String fav_language) {
        this.fav_language = fav_language;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
