package com.andre.server.controller;

import com.andre.server.dto.UserDTO;
import com.andre.server.model.User;
import com.andre.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("user/{email}")
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

}