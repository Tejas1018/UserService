package com.service.userservice.repository;

import com.service.userservice.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tokenRepository extends JpaRepository<Token, Long> {
}
