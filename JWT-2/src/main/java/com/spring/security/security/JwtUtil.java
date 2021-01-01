package com.spring.security.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class JwtUtil {

    public static String generateToken(Authentication authentication, String secretKey, Integer expirationDay){
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", getAuthorities(authentication))
                .setIssuedAt(new Date())
                .setExpiration(calculateExpirationDate(expirationDay))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .compact();
    }

    private static List<String> getAuthorities(Authentication authentication) {
         return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    private static Date calculateExpirationDate(Integer expirationDay){
        Instant expirationTime = LocalDate.now()
                .plusDays(expirationDay)
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return Date.from(expirationTime);
    }

    public static String extractUsername(String jwtToken, String secretKey){
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }
}
