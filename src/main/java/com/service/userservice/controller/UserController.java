package com.service.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.userservice.dto.LoginRequestDto;
import com.service.userservice.dto.SignUpRequestDto;
import com.service.userservice.dto.TokenDto;
import com.service.userservice.dto.UserDto;
import com.service.userservice.model.Token;
import com.service.userservice.model.User;
import com.service.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private  UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto loginRequestDto){
        Token token = userService.login(loginRequestDto.getEmail(),
                                        loginRequestDto.getPassword());
        if(token == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TokenDto tokenDto = TokenDto.from(token);
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDTO)throws JsonProcessingException {
        // Logic for user sign up
        User user = userService.signUp(signUpRequestDTO.getName(),
                                        signUpRequestDTO.getEmail(),
                                        signUpRequestDTO.getPassword());
        return UserDto.from(user);
    }
    @GetMapping("/validateToken/{tokenValue}")
    public ResponseEntity<UserDto> validateToken(@PathVariable String tokenValue){
        User user = userService.validateToken(tokenValue);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
        return responseEntity;
    }
}
