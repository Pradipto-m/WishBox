package com.pradipto.wishbox.service;

import com.pradipto.wishbox.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> getUserDetail (String userid);

    ResponseEntity<?> registerUser (UserEntity user);

    ResponseEntity<String> signIn (String username,String email, String password);

}
