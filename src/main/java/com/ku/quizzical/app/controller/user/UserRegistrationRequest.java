package com.ku.quizzical.app.controller.user;

public record UserRegistrationRequest(
        String name,
        String email,
        String password) {
}
