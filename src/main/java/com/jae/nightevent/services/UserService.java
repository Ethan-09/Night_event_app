package com.jae.nightevent.services;

import com.jae.nightevent.dto.UserDTO;
import com.jae.nightevent.entities.User;
import com.jae.nightevent.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        String encryptedPassword = encoder.encode(userDTO.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }
}
