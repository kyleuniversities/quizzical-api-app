package com.ku.quizzical.app.models.structure;

/**
 * Structure class for User Session
 */
public final class UserSession {
    // Instance Fields
    private String userId;
    private String username;

    // New Instance Method
    public static UserSession newInstance(String userId, String username) {
        return new UserSession(userId, username);
    }

    // Constructor Method
    private UserSession(String userId, String username) {
        super();
        this.userId = userId;
        this.username = username;
    }

    // Accessor Methods
    public String getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }
}