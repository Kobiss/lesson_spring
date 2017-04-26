package com.softgroup.response;

/**
 * Created by java-Andr on 26.04.2017.
 */
public class MessResponse extends Response {

    private String message;

    public MessResponse(int status, String message) {
        super(status);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
