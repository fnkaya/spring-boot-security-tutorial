package com.spring.web.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller {

    @PostMapping("/validate")
    public ResponseEntity<User> validate(@Valid @RequestBody User user){
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}

