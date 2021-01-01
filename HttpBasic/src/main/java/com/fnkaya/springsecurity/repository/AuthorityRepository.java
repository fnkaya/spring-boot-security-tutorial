package com.fnkaya.springsecurity.repository;

import com.fnkaya.springsecurity.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
