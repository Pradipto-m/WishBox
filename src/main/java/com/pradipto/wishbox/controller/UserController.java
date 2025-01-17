package com.pradipto.wishbox.controller;

import com.pradipto.wishbox.model.UserEntity;
import com.pradipto.wishbox.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserServiceImpl services;

    @GetMapping("getUser")
    public ResponseEntity<?> getUser(@RequestParam String username){
        return services.getUserDetail(username);
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

    @PostMapping(value = "login",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    public ResponseEntity<String> signIn (@RequestParam String username,
                                          @RequestParam String email,
                                          @RequestParam String password) {
        try {
            return services.signIn(username, email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("User doesn't exists", HttpStatus.BAD_REQUEST);
        }
    }

}
