package com.ramadan.safari.model;

public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String city;
    private String password;
//    private String rate;
//    private String feedback;

    public User() {
    }

//    public User(String first_name, String last_name, String email, String phone, String city, String password, String rate, String feedback) {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.phone = phone;
//        this.city = city;
//        this.password = password;
//        this.rate = rate;
//        this.feedback = feedback;
//
//    }

    public User(String first_name, String last_name, String email, String phone, String city, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.password = password;
    }
//
//    public String getRate() {
//        return rate;
//    }
//
//    public void setRate(String rate) {
//        this.rate = rate;
//    }
//
//    public String getFeedback() {
//        return feedback;
//    }
//
//    public void setFeedback(String feedback) {
//        this.feedback = feedback;
//    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
