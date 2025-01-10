package com.pradipto.wishbox.service;

import com.pradipto.wishbox.model.UserEntity;
import com.pradipto.wishbox.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> getUserDetail (Integer id) {
        try {
            Optional<UserEntity> user = userDao.findById(id);
            if (user.isEmpty())
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(userDao.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Dao error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> registerUser (UserEntity user) {
        try {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            user.setProfile("https://cdn-icons-png.flaticon.com/512/17780/17780123.png");
            return new ResponseEntity<>(userDao.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Dao save error " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
