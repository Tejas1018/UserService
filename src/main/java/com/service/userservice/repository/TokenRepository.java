package com.service.userservice.repository;

import com.service.userservice.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    // Save a new token
    Token save(Token token);

    // Find a token by its value and ensure it hasn't expired
    Optional<Token> findByValueAndExpiryDateAfter(String value, Date currentDate);
}
