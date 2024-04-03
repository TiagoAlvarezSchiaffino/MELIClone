package com.example.demo.service;

import com.example.demo.dto.token.TokenDto;
import com.example.demo.dto.user.UserLoginDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.user.UserTokenDto;

public interface IAuthService {

    void register(UserRegisterDto userRegisterDto);

    UserTokenDto login(UserLoginDto userLoginDto);
}