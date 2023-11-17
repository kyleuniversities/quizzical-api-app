package com.ku.quizzical.app.models.structure;

/**
 * Structure class for Login Credentials
 */
public final class UserLoginCredentials {
    // Instance Fields
    private String username;
    private String password;

    // New Instance Method
    public static UserLoginCredentials newInstance(String username, String password) {
        return new UserLoginCredentials(username, password);
    }

    // Constructor Method
    private UserLoginCredentials(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    // Accessor Methods
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
