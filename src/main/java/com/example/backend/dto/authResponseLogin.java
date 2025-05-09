package com.example.backend.dto;

public class authResponseLogin {
    private String responseMessage;
    private String jwtToken;

    public authResponseLogin(String loginSuccessful, String jwtToken) {
        this.responseMessage = loginSuccessful;
        this.jwtToken = jwtToken;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
