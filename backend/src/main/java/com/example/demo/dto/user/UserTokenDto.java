package com.example.demo.dto.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTokenDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String numberPhone;
    private String token;
}