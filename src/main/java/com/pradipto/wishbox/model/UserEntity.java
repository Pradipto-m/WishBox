package com.pradipto.wishbox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
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

}
