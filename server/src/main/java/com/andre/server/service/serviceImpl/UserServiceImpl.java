package com.andre.server.service.serviceImpl;

import com.andre.server.dto.UserDTO;
import com.andre.server.model.Supplier;
import com.andre.server.model.User;
import com.andre.server.repository.UserRepository;
import com.andre.server.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUser() {

        List<User> userList = new ArrayList<>();
        List<UserDTO> userDTOList = new ArrayList<>();

        userRepository.findAll().forEach(user -> userList.add(user)); //Remember to study this deeper (Lambda, Stream)

        for(User user : userList) {
            userDTOList.add(modelMapper.map(user, UserDTO.class));
        }

        return userDTOList;

    }

    @Override
    public UserDTO getUserByEmail(String email) {

        List<UserDTO> userDTOList;
        userDTOList = getAllUser();

        for(UserDTO userDTO : userDTOList) {
            if(userDTO.getEmail().equals(email)) {
                return userDTO;
            }
        }

        return null;

    }

    @Override
    public ResponseEntity<User> saveUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<User>(user, null, HttpStatus.CREATED);
    }

}
