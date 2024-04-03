package com.example.demo.dto.user;

import com.example.demo.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String numberPhone;
    private String role;
}