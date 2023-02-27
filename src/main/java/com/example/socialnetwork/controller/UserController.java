package com.example.socialnetwork.controller;

import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.service.UserServiceImpl;
import com.example.socialnetwork.service.serviceClass.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(int id) {
        return ResponseEntity.status(200).body(userService.getByUserId(id));
    }
}
