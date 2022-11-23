package com.example.kotlinfirstproject;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;


public class ServiceError {
    public static final ServiceError UNKNOWN = new ServiceError(-1, "Unknown", "");
    public static final ServiceError IOEXCEPTION = new ServiceError(-2, "IOException", "");

    private int statusCode;
    private final String error;
    private @SerializedName("error_description")
    String message;

    public ServiceError(int statusCode, String error, String description) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ServiceError from(Throwable t) {

        if (t instanceof IOException) {
            return IOEXCEPTION;
        }

        return UNKNOWN;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
