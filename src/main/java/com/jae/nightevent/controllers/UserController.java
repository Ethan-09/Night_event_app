package com.jae.nightevent.controllers;

import com.jae.nightevent.entities.User;
import com.jae.nightevent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.Data;

@Data
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> getUsers(){
    List<User> users=userRepository.findAll();
    return users;
    }
    @GetMapping(path= "/users/{id}")
    public User getUserById(Integer id){
        User user = userRepository.findUserById(id);
        return user;
    }
}