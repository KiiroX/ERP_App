package com.andre.server.service.serviceImpl;

import com.andre.server.dto.UserDTO;
import com.andre.server.model.User;
import com.andre.server.repository.UserRepository;
import com.andre.server.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//This way the library can locate and match properties easier (Entities)
//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

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

}
