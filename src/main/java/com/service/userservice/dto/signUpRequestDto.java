package com.service.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class signUpRequestDto {
    private String email;
    private String password;
}
