package com.softgroup.model;

import com.softgroup.request.TankRequest;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tank implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private String country;
    private int speed;
    private String color;
    private int price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private User owner;


    public Tank() {
    }

    public Tank(String name, String country, int speed, String color, int price) {
        this.name = name;
        this.country = country;
        this.speed = speed;
        this.color = color;
        this.price = price;
    }

    public Tank(TankRequest tankRequest) {
        this.name = tankRequest.getName();
        this.country = tankRequest.getCountry();
        this.speed = tankRequest.getSpeed();
        this.color = tankRequest.getColor();
        this.price = tankRequest.getPrice();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int weigth) {
        this.price = weigth;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
