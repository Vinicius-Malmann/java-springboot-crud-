package com.userRegistration.service;

import com.userRegistration.dto.UserDto;
import com.userRegistration.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
