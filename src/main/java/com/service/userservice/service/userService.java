package com.service.userservice.service;

import com.service.userservice.Exceptions.userNotFoundException;
import com.service.userservice.model.Token;
import com.service.userservice.model.User;
import com.service.userservice.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService {
    UserRepository userRepository;
    public userService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public Token login(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new userNotFoundException("User with this email Id is not present.");
        }
        return null;
    }

    public User signUp(String name,String email,String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            // Redirect to login page
            return null;
        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
