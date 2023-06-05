package com.example.project_oop;

public class Passengers {

    private String name;
    private String username;
    private String password;

    public Passengers(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}