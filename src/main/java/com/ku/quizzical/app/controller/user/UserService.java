package com.ku.quizzical.app.controller.user;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto question);

    List<UserDto> getAllUsers();

    UserDto getUserById(String id);

    UserDto updateUser(UserDto question, String id);

    void deleteUser(String id);
}
