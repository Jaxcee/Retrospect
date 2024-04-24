package com.example.retrospect.user.service;

import com.example.retrospect.user.dto.LoginDTO;
import com.example.retrospect.user.dto.SignUpDTO;
import com.example.retrospect.user.entity.UserEntity;

import java.util.Optional;

public interface IUserService {
    String Userlogin(LoginDTO loginDTO);

    String userSignup(SignUpDTO signUpDTO);

    Optional<UserEntity> getUserByJWT(String token);
}
