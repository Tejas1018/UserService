package com.service.userservice.service;

import com.service.userservice.Exceptions.InvalidTokenException;
import com.service.userservice.Exceptions.UserNotFoundException;
import com.service.userservice.model.Token;
import com.service.userservice.model.User;
import com.service.userservice.repository.UserRepository;
import com.service.userservice.repository.TokenRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private  UserRepository userRepository;
    private  TokenRepository tokenRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, TokenRepository tokenRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Token login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            return null;
        }
        User user = optionalUser.get();

        if(!passwordEncoder.matches(password, user.getPassword())){
            return null;
        }
        Token token = new Token();
        token.setUser(user);
        LocalDate localDate = LocalDate.now().plusDays(30);
        Date expiryDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        token.setExpiryDate(expiryDate);
        token.setValue(RandomStringUtils.randomAlphanumeric(64));

        return tokenRepository.save(token);
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
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User validateToken(String tokenValue) {
        Optional<Token> tokenOptional = tokenRepository.findByValueAndExpiryDateAfter(tokenValue, new Date());
        if (tokenOptional.isEmpty()) {
            throw new InvalidTokenException("Token is invalid or has expired. Please log in again.");
        }
        return tokenOptional.get().getUser();
    }
}



