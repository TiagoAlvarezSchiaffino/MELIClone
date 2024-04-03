package com.example.demo.service;


import com.example.demo.dto.user.UserDto;

public interface IUserService {

    UserDto findByEmail(String email);

}