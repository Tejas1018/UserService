package com.service.userservice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "roles")
public class Role extends BaseModel{
    private String value;
}
