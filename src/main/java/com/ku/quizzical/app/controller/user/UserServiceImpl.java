package com.ku.quizzical.app.controller.user;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    // Instance Fields
    private UserRepository repository;

    // Constructor Method
    public UserServiceImpl(UserRepository repository) {
        super();
        this.repository = repository;
    }

    // Interface Methods
    @Override
    public User saveUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return this.repository.findById(id).get();
    }

    @Override
    public User updateUser(User user, String id) {
        User existingUser = this.repository.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        this.repository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(String id) {
        this.repository.deleteById(id);
    }
}
