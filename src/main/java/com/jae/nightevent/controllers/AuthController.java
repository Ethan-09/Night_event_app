package com.jae.nightevent.controllers;

import com.jae.nightevent.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping(path = "/login")
    public ResponseEntity<String> basicauth(UsernamePasswordAuthenticationToken upa) {
        User u = (User) upa.getPrincipal();
        return ResponseEntity.ok().body("{\"resp\":\"Login exitoso\", \"id\":"+u.getId()+"}");

    }
}
