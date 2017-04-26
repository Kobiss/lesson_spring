package com.softgroup.response;

import com.softgroup.model.Tank;

/**
 * Created by java-Andr on 26.04.2017.
 */
public class TankResponse extends Response {

    private Tank tank;

    public TankResponse(int status, Tank tank) {
        super(status);
        this.tank = tank;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
