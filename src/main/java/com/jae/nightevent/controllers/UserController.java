package com.jae.nightevent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jae.nightevent.dto.UserDTO;
import com.jae.nightevent.services.UserService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/users")
public class UserController {


}
