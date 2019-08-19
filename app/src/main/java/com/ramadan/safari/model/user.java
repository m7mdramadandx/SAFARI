package com.ramadan.safari.model;

import com.google.firebase.firestore.Exclude;

import java.util.HashMap;
import java.util.Map;

public class user {
    private long user_id = 0;
    private String first_name;
    private String last_name;
    private String email;
    private int phone;
    private int age;
    private String password;

    public user() {
    }

    public user(String first_name, String last_name) {
        user_id++;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("firstName", first_name);
        result.put("lastName", last_name);
        result.put("email", email);
        result.put("phone", phone);
        result.put("age", age);
        result.put("password", password);
        return result;
    }
}
