package com.jae.nightevent.controllers;

import com.jae.nightevent.dto.UserDTO;
import com.jae.nightevent.entities.User;
import com.jae.nightevent.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    @Autowired
    UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<String> basicauth(UsernamePasswordAuthenticationToken upa) {
        User u = (User) upa.getPrincipal();
        return ResponseEntity.ok().body("{\"resp\":\"Login exitoso\", \"id\":"+u.getId()+"}");
    }

    @PostMapping(path = "/register")
    public void createUser(@RequestBody UserDTO user){
        userService.saveUser(user);
    }

}
