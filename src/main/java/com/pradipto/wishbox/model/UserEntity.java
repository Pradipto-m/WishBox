package com.pradipto.wishbox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userid;
    @Column(unique = true, nullable = false, length = 10)
    @NotNull(message = "You must provide a username")
    @Size(min = 4, max = 10, message = "Must be within 4 to 10 characters")
    private String username;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Field cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    @Column(unique = true, nullable = false, length = 10)
    @NotNull(message = "Please provide a valid phone number")
    @Size(min = 10, max = 10, message = "Please provide a valid phone number")
    private String phone;
    @Column(nullable = false)
    @NotNull(message = "Field cannot be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%\\-^&_+()]).{6,}$")
    private String password;
    private String address;
    private String profile;

    public UserEntity() {}

    public UserEntity(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profile = "https://cdn-icons-png.flaticon.com/512/17780/17780123.png";
    }

    public UserEntity(String username, String email, String phone, String password, String address) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.profile = "https://cdn-icons-png.flaticon.com/512/17780/17780123.png";
    }

    public UserEntity(String username,
                      String email,
                      String phone,
                      String password,
                      String address,
                      String profile) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.profile = profile;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
