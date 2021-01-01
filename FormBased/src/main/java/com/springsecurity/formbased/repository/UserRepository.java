package com.springsecurity.formbased.repository;

import com.springsecurity.formbased.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
