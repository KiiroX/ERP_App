package com.andre.server.controller;

import com.andre.server.model.User;
import com.andre.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("hello-user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @GetMapping("user")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

}