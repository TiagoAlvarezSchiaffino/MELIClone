package com.example.demo.controller;

import com.example.demo.dto.token.TokenDto;
import com.example.demo.dto.user.UserLoginDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.service.IAuthService;
import com.example.demo.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping(value = "/register")
    private ResponseEntity<TokenDto> register(@RequestBody UserRegisterDto userRegisterDto) {
        authService.register(userRegisterDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping(value = "/login")
    private ResponseEntity<TokenDto> login(@RequestBody UserLoginDto userLoginDto) {
        return new ResponseEntity<>(authService.login(userLoginDto), HttpStatus.OK);
    }
}