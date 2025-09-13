package com.service.userservice.dto;

import com.service.userservice.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class userDto {
    private long userId;
    private String name;
    private List<Role> roles;
}
