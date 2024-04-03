package com.example.demo.service.impl;

import com.example.demo.config.jwt.JwtService;
import com.example.demo.dto.token.TokenDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserLoginDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.user.UserTokenDto;
import com.example.demo.model.enums.Role;
import com.example.demo.model.entity.User;
import com.example.demo.mapper.IUserMapper;
import com.example.demo.repository.IUserRepositoryJpa;
import com.example.demo.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final IUserRepositoryJpa userRepositoryJpa;
    private final IUserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User user = this.userMapper.toUser(userRegisterDto);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        this.userRepositoryJpa.save(user);
    }

    @Override
    public UserTokenDto login(UserLoginDto userLoginDto) {
        User user = this.userRepositoryJpa.findByEmail(userLoginDto.getEmail()).orElseThrow(() ->
                new RuntimeException("El email no se encuentra registrado"));
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userLoginDto.getEmail(), userLoginDto.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(user);
        UserDto userDto = this.userMapper.toUserDto(user);
        return UserTokenDto.builder()
                .user(userDto)
                .token(token)
                .build();
    }
}