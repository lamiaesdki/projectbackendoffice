package com.example.b_office.model;

public class LoginResponse {

    private String message;
    private String role;
    private Long userId;

    // Constructor with message and role (for backward compatibility)
    public LoginResponse(String message, String role) {
        this.message = message;
        this.role = role;
    }

    // Constructor with message, role, and userId
    public LoginResponse(String message, String role, Long userId) {
        this.message = message;
        this.role = role;
        this.userId = userId;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
