package com.service.userservice.dto;

import com.service.userservice.model.Role;
import com.service.userservice.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private long userId;
    private String name;
    private String email;
    private List<Role> roles;
    public static UserDto from(User user){
        if(user == null) return null;
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setUserId(user.getId());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
