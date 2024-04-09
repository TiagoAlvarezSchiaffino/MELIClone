package com.example.demo.service;


import com.example.demo.dto.user.UserDto;
import com.example.demo.model.entity.User;


public interface IUserService {

    UserDto findByEmail(String email);

    User findById(Integer id);

    boolean isRoleTienda(Integer userId);

    UserDto findById(Long userId);
}