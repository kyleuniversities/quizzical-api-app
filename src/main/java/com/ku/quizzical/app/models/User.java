package com.ku.quizzical.app.models;

import jakarta.persistence.*;

/**
 * Model class for Quiz Users
 */
@Entity
@Table(name = "user")
public final class User {

    // Instance Fields
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    // New Instance Method
    public static User newInstance(String id, String username, String email, String password) {
        return new User(id, username, email, password);
    }

    // Constructor Methods
    private User() {
        super();
    }

    private User(String id, String username, String email, String password) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Accessor Methods
    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    // Mutator Methods
    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // To String Method
    @Override
    public String toString() {
        return String.format("User(\"%s\", \"%s\", %s, \"%s\")", this.username, this.email,
                this.password, this.id);
    }
}
