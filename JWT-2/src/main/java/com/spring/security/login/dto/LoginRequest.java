package com.spring.security.login.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

}
