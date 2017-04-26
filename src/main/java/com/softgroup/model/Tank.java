package com.softgroup.model;

import com.softgroup.request.TankRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by java-Andr on 25.04.2017.
 */

@Entity
public class Tank {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private String country;
    private int speed;
    private String color;
    private int weigth;

    public Tank() {
    }

    public Tank(String name, String country, int speed, String color, int weigth) {
        this.name = name;
        this.country = country;
        this.speed = speed;
        this.color = color;
        this.weigth = weigth;
    }

    public Tank(TankRequest tankRequest) {
        this.name = tankRequest.getName();
        this.country = tankRequest.getCountry();
        this.speed = tankRequest.getSpeed();
        this.color = tankRequest.getColor();
        this.weigth = tankRequest.getWeigth();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Tank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
