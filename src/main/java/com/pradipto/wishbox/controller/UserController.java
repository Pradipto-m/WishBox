package com.pradipto.wishbox.controller;

import com.pradipto.wishbox.model.UserEntity;
import com.pradipto.wishbox.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService services;

    @GetMapping("getUser")
    public ResponseEntity<?> getUser(@RequestParam Integer id){
        return services.getUserDetail(id);
    }

    @PostMapping(value = "signup",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    public ResponseEntity<?> registerUser (@ModelAttribute @Valid UserEntity user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Binding result: " + result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return services.registerUser(user);
    }

}
