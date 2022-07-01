package com.example.eschool.utils;

public class ErrorResponse {
    private String error;

    public ErrorResponse(String error){
        setError(error);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
