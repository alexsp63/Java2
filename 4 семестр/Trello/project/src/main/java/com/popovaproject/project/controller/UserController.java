package com.popovaproject.project.controller;

import com.popovaproject.project.entity.User;
import com.popovaproject.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/api/user")
    private ResponseEntity<?> create(@RequestBody User user){
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
    @GetMapping(value = "/api/user")
    private ResponseEntity<List<User>> readAll(){
        final List<User> userList = userService.findAll();
        return userList != null && !userList.isEmpty()
                ? new ResponseEntity<>(userList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "api/user/{id}")
    public ResponseEntity<User> getOne(@PathVariable(name = "id") User user) {
        final User currentUser = user;
        return user != null
                ? new ResponseEntity<>(currentUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "api/user/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") User userFromDB,
                                 @RequestBody User user) {
        User updatedUser = userService.update(user, userFromDB);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "api/user/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable(name = "id") User user) {
        if (userService.delete(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
