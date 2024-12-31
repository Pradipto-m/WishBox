package com.pradipto.wishbox.repo;

import com.pradipto.wishbox.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Integer> {

}
