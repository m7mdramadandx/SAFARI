package com.ramadan.safari.model;

public class offer {
    private String duration;
    private String hotel_name;
    private String rate;
    private String transportation_type;
    private String cost;
    private String img_url;
    private String date;

    public offer() {
    }

    public offer(String duration, String hotel_name, String rate, String transportation_type, String cost, String img_url, String date) {

        this.duration = duration;
        this.hotel_name = hotel_name;
        this.rate = rate;
        this.transportation_type = transportation_type;
        this.cost = cost;
        this.img_url = img_url;
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTransportation_type() {
        return transportation_type;
    }

    public void setTransportation_type(String transportation_type) {
        this.transportation_type = transportation_type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
