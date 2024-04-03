package com.example.demo.service.impl;

import com.example.demo.dto.user.UserDto;
import com.example.demo.mapper.IUserMapper;
import com.example.demo.repository.IUserRepositoryJpa;
import com.example.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepositoryJpa userRepositoryJpa;

    private final IUserMapper userMapper;

    @Override
    public UserDto findByEmail(String email) {
//        Optional<User> byEmail = this.userRepositoryJpa.findByEmail(email);

        return this.userRepositoryJpa.findByEmail(email)
                .map(userMapper::toUserDto)
                .orElseThrow(() -> new RuntimeException("El usuario no existe."));
    }

    @Override
    public UserDto findById(Long userId) {
//        Optional<User> byId = this.userRepositoryJpa.findById(userId);
        return this.userRepositoryJpa.findById(userId)
                .map(this.userMapper::toUserDto)
                .orElseThrow(()-> new RuntimeException("Id del usuario no existe."));
    }
}