package com.ramadan.safari.model;

public class Hotel_blog {
    private String hotel_name;
    private String hotel_rate;
    private String hotel_location;
    private String hotel_beach;
    private String hotel_img_url;
    //private String hotel_cost;

    public Hotel_blog() {
    }

    public Hotel_blog(String hotel_name, String hotel_rate, String hotel_location, String hotel_beach, String hotel_img_url) {
        this.hotel_name = hotel_name;
        this.hotel_rate = hotel_rate;
        this.hotel_location = hotel_location;
        this.hotel_beach = hotel_beach;
        this.hotel_img_url = hotel_img_url;
        //this.cost = cost;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_rate() {
        return hotel_rate;
    }

    public void setHotel_rate(String hotel_rate) {
        this.hotel_rate = hotel_rate;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getHotel_beach() {
        return hotel_beach;
    }

    public void setHotel_beach(String hotel_beach) {
        this.hotel_beach = hotel_beach;
    }

    public String getHotel_img_url() {
        return hotel_img_url;
    }

    public void setHotel_img_url(String hotel_img_url) {
        this.hotel_img_url = hotel_img_url;
    }

}
