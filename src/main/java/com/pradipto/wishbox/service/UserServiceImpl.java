package com.pradipto.wishbox.service;

import com.pradipto.wishbox.model.UserEntity;
import com.pradipto.wishbox.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<?> getUserDetail (String userid) {
        try {
            UserEntity user = userDao.findByUsername(userid);
            if (user == null)
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Dao error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
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

    @Override
    public ResponseEntity<String> signIn (String username, String email, String password) {
        try {
            UserEntity user = userDao.findByUsername(username);
            if (user == null)
                return new ResponseEntity<>("User doesn't exist, check username", HttpStatus.NOT_FOUND);
            if (!Objects.equals(user.getEmail(), email))
                return new ResponseEntity<>("Recheck email id", HttpStatus.UNAUTHORIZED);
            if (!passwordEncoder.matches(password, user.getPassword()))
                return new ResponseEntity<>("Password invalid", HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>("User logging in successful", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
