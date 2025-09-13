package com.service.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity(name = "tokens")
public class Token extends BaseModel {
    private String value;
    private Date expiryDate;
    @ManyToOne
    private User user;
}
