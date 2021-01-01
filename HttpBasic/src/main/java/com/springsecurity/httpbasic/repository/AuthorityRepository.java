package com.springsecurity.httpbasic.repository;

import com.springsecurity.httpbasic.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
