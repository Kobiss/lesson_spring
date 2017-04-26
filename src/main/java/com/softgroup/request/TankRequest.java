package com.softgroup.request;

/**
 * Created by java-Andr on 26.04.2017.
 */
public class TankRequest {
    private String name;
    private String country;
    private int speed;
    private String color;
    private int weigth;

    public TankRequest() {
    }

    public TankRequest(String name, String country, int speed, String color, int weigth) {
        this.name = name;
        this.country = country;
        this.speed = speed;
        this.color = color;
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public boolean validate(){
        if(this.name.isEmpty()||
        this.country.isEmpty()||
        this.color.isEmpty()) return false;
        return true;
    }
}
