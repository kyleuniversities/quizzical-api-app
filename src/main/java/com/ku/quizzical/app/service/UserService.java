package com.ku.quizzical.app.service;

import java.util.List;
import com.ku.quizzical.app.models.User;

public interface UserService {
    User saveUser(User question);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUser(User question, String id);

    void deleteUser(String id);
}
