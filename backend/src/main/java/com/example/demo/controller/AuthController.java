package com.example.demo.controller;

import com.example.demo.dto.message.MessageDto;
import com.example.demo.dto.token.TokenDto;
import com.example.demo.dto.user.UserLoginDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.user.UserTokenDto;
import com.example.demo.service.IAuthService;
import com.example.demo.service.impl.AuthServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Authentication", description = "Registro y login de usuario.")
public class AuthController {
    private final IAuthService authService;

    @PostMapping(value = "/register")
    @Operation(summary = "Registrar usuario.")
    private ResponseEntity<MessageDto> register(@RequestBody UserRegisterDto userRegisterDto) {
        authService.register(userRegisterDto);
        MessageDto messageDto = MessageDto.builder()
                .message("Usuario registrado.")
                .code(HttpStatus.CREATED.value())
                .build();
        return new ResponseEntity<>(messageDto, HttpStatus.CREATED);
    }


    @PostMapping(value = "/login")
    @Operation(summary = "Iniciar sesion usuario.")
    private ResponseEntity<UserTokenDto> login(@RequestBody UserLoginDto userLoginDto) {
        return new ResponseEntity<>(authService.login(userLoginDto), HttpStatus.OK);
    }
}