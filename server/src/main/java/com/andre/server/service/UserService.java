package com.andre.server.service;

import com.andre.server.dto.UserDTO;
import com.andre.server.model.User;
import com.andre.server.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//This way the library can locate and match properties easier (Entities)
//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUser() {

        List<User> users = new ArrayList<User>();
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();

        userRepository.findAll().forEach(user -> users.add(user));

        for(User user : users) {
            usersDTO.add(modelMapper.map(user, UserDTO.class));
        }

        return usersDTO;

    }

}
