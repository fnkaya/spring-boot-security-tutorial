package com.spring.security;

import com.spring.security.util.DatabasePopulator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityApplication {

    private final DatabasePopulator databasePopulator;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @PostConstruct
    public void populateDatabase(){
        databasePopulator.populateDatabase();
    }
}
