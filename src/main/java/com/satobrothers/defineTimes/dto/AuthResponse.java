package com.satobrothers.defineTimes.dto;

public class AuthResponse {
    private String token;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    // getter e setter
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
