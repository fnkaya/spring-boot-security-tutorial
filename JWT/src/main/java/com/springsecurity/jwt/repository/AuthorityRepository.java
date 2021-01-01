package com.springsecurity.jwt.repository;

import com.springsecurity.jwt.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
