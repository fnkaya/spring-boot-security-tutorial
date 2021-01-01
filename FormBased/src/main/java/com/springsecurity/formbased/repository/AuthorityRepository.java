package com.springsecurity.formbased.repository;

import com.springsecurity.formbased.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
