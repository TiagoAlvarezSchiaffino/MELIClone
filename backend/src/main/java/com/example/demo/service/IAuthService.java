package com.example.demo.service;

import com.example.demo.dto.token.TokenDto;
import com.example.demo.dto.user.UserLoginDto;
import com.example.demo.dto.user.UserRegisterDto;

public interface IAuthService {

    void register(UserRegisterDto userRegisterDto);

    TokenDto login(UserLoginDto userLoginDto);
}