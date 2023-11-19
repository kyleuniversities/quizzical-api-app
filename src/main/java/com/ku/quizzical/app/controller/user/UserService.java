package com.ku.quizzical.app.controller.user;

import java.util.List;

public interface UserService {
    User saveUser(User question);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUser(User question, String id);

    void deleteUser(String id);
}
