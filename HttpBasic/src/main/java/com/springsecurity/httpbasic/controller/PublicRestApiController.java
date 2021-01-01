package com.springsecurity.httpbasic.controller;

import com.springsecurity.httpbasic.model.User;
import com.springsecurity.httpbasic.repository.AuthorityRepository;
import com.springsecurity.httpbasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
@RequiredArgsConstructor
public class PublicRestApiController {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @GetMapping("test-1")
    public String test1() { return "API Test 1"; }

    @GetMapping("test-2")
    public String test2() { return "API Test 2"; }

    @GetMapping("authorities")
    public List<? extends GrantedAuthority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @GetMapping("users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
