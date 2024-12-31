package com.pradipto.wishbox.controller;

import com.pradipto.wishbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService services;

    @GetMapping("getUser")
    public String getUser(){
        return "Hello world I am a user!";
    }

}
