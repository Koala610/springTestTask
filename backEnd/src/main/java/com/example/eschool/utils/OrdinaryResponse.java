package com.example.eschool.utils;

public class OrdinaryResponse {
    private Object response;
    private Object body;

    public OrdinaryResponse(Object response){
        this.setResponse(response);
    }
    public OrdinaryResponse(Object response, Object body){

        this.setResponse(response);
        this.setBody(body);
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
