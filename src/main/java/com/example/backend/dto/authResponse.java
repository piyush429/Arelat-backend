package com.example.backend.dto;

public class authResponse {
    private String responseMessage;

    public authResponse(String loginSuccessful) {
        this.responseMessage = loginSuccessful;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}

