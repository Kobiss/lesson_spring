package com.softgroup.response;

/**
 * Created by java-Andr on 26.04.2017.
 */
public abstract class Response {
    private int status;

    public Response(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
