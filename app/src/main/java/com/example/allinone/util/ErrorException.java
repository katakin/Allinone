package com.example.allinone.util;

/**
 * Created by katakin on 22/07/17.
 */

public class ErrorException extends RuntimeException {
    public ErrorException() {
    }

    public ErrorException(String message) {
        super(message);
    }

    public ErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorException(Throwable cause) {
        super(cause);
    }
}