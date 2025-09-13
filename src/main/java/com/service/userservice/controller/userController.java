package com.service.userservice.controller;

import com.service.userservice.dto.loginRequestDto;
import com.service.userservice.dto.signUpRequestDto;
import com.service.userservice.dto.userDto;
import com.service.userservice.model.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    @PostMapping("/login")
    public Token login(@RequestBody loginRequestDto loginRequestDto){
        // Logic for user login
        return null;
    }

    @PostMapping("/signup")
    public userDto signUp(@RequestBody signUpRequestDto signUpRequestDTO){
        // Logic for user sign up
        return null;
    }
    @GetMapping("/validateToken/{tokenValue}")
    public ResponseEntity<userDto> validateToken(@PathVariable String tokenValue){
        return null;
    }
}
