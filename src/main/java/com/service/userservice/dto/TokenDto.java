package com.service.userservice.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.service.userservice.model.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TokenDto {
    private String tokenValue;
    private Date expiryDate;

    public static TokenDto from(Token token) {
        if(token == null) {
            return null;
        }
        TokenDto dto = new TokenDto();
        dto.setTokenValue(token.getValue());
        dto.setExpiryDate(token.getExpiryDate());
        return dto;
    }

}
