package com.springsecurity.jwt.controller;

import com.springsecurity.jwt.model.User;
import com.springsecurity.jwt.repository.AuthorityRepository;
import com.springsecurity.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping()
    public String data() { return "Some public data"; }

    @GetMapping("management/reports")
    public String reports() { return "Some report data"; }

    @GetMapping("admin/authorities")
    public List<? extends GrantedAuthority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @GetMapping("admin/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
