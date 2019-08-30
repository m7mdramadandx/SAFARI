package com.ramadan.safari.model;

public class Landmark_Blog {
    private String landmark_name;
    private String landmark_rate;
    private String landmark_location;
    private String landmark_cost;
    private String landmark_desc;
    private String landmark_img_url;

    public Landmark_Blog() {
    }

    public Landmark_Blog(String landmark_name, String landmark_rate, String landmark_location, String landmark_cost, String landmark_desc, String landmark_img_url) {
        this.landmark_name = landmark_name;
        this.landmark_rate = landmark_rate;
        this.landmark_location = landmark_location;
        this.landmark_cost = landmark_cost;
        this.landmark_desc = landmark_desc;
        this.landmark_img_url = landmark_img_url;
    }

    public String getLandmark_location() {
        return landmark_location;
    }

    public void setLandmark_location(String landmark_location) {
        this.landmark_location = landmark_location;
    }

    public String getLandmark_name() {
        return landmark_name;
    }

    public void setLandmark_name(String landmark_name) {
        this.landmark_name = landmark_name;
    }

    public String getLandmark_rate() {
        return landmark_rate;
    }

    public void setLandmark_rate(String landmark_rate) {
        this.landmark_rate = landmark_rate;
    }

    public String getLandmark_cost() {
        return landmark_cost;
    }

    public void setLandmark_cost(String landmark_cost) {
        this.landmark_cost = landmark_cost;
    }

    public String getLandmark_desc() {
        return landmark_desc;
    }

    public void setLandmark_desc(String landmark_desc) {
        this.landmark_desc = landmark_desc;
    }

    public String getLandmark_img_url() {
        return landmark_img_url;
    }

    public void setLandmark_img_url(String landmark_img_url) {
        this.landmark_img_url = landmark_img_url;
    }


}
