package com.andre.server.service;

import com.andre.server.dto.UserDTO;
import com.andre.server.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    public List<UserDTO> getAllUser();

    public UserDTO getUserByEmail(String email);

    public ResponseEntity<User> saveUser(User user);

}
