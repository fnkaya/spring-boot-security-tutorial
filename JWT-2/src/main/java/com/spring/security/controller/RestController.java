package com.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/index")
    public String read(){
        return "<h1>Welcome to Spring Security</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>This is ADMIN PAGE</h1>";
    }

    @GetMapping("/user")
    public String secret(){
        return "<h1>This is USER PAGE</h1>";
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String test(){
        return "<h1>This is PRE AUTHORIZE PAGE</h1>";
    }
}
