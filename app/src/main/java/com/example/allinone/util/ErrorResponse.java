package com.example.allinone.util;

/**
 * Created by katakin on 22/07/17.
 */

public class ErrorResponse {
    private String code;
    private String message;
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}