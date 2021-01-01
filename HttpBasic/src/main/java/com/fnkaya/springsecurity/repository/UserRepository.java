package com.fnkaya.springsecurity.repository;

import com.fnkaya.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
