package com.ku.quizzical.app.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ku.quizzical.app.models.User;
import com.ku.quizzical.app.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/users")
public final class UserController {
    // Instance Fields
    private UserServiceImpl service;

    // Constructor Method
    public UserController(UserServiceImpl service) {
        super();
        this.service = service;
    }

    // CREATE Method
    // Saves a User
    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User question) {
        return new ResponseEntity<User>(this.service.saveUser(question), HttpStatus.OK);
    }

    // READ Method
    // Gets all Users
    @GetMapping()
    public List<User> getAllUsers() {
        return this.service.getAllUsers();
    }

    // READ Method
    // Gets a User by its id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<User>(this.service.getUserById(id), HttpStatus.OK);
    }

    // UPDATE Method
    // Updates a User
    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User question) {
        return new ResponseEntity<User>(this.service.updateUser(question, id), HttpStatus.OK);
    }

    // DELETE Method
    // Deletes a User
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable String id) {
        try {
            this.service.deleteUser(id);
        } catch (Exception e) {
            // Do Nothing
        }
        return "\"The User with id \\\"" + id + "\\\" has been deleted.\"";
    }
}
