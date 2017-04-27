package com.softgroup.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by java-Andr on 27.04.2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String login;
    private String pass;
    private int money;

    @OneToMany(mappedBy = "owner")
    private List<Tank> tanks;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }
}
