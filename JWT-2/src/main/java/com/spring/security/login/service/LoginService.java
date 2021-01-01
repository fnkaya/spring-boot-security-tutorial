package com.spring.security.login.service;

import com.spring.security.login.dto.LoginRequest;
import com.spring.security.login.dto.LoginResponse;
import com.spring.security.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${security.jwt.secretKey}")
    private String secretKey;

    private final DaoAuthenticationProvider authenticationProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication user = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        try{
            Authentication authenticatedUser = authenticationProvider.authenticate(user);
            String token = JwtUtil.generateToken(authenticatedUser, secretKey, 7);
            return new LoginResponse(token);
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
        return null;
    }
}
