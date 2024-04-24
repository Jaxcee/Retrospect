package com.example.retrospect.user.service;

import com.example.retrospect.user.dto.LoginDTO;
import com.example.retrospect.user.dto.SignUpDTO;
import com.example.retrospect.user.entity.UserEntity;
import com.example.retrospect.user.repository.IUserRepository;
import com.example.retrospect.util.UserJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class UserService implements IUserService {
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    UserEntity userEntity;

    @Autowired
    UserJWT userJWT;

    @Override
    public String userSignup(SignUpDTO signUpDTO) {
        String encryptedPassword=bCryptPasswordEncoder.encode(signUpDTO.getUserPassword());
        signUpDTO.setUserPassword((encryptedPassword));
        iUserRepository.save(userEntity);
        userEntity.setUserEmail(signUpDTO.getUserEmail());
        userEntity.setUserName(signUpDTO.getUserName());
        userEntity.setUserPassword(signUpDTO.getUserPassword());
        userEntity.setUserRole(signUpDTO.getUserRole());


        return  "You have been signed up successfully";

    }

    @Override
    public Optional<UserEntity> getUserByJWT(String token) {
        int userId = userJWT.decodeToken(token);
        System.out.println(" service" + userId);
        return iUserRepository.findById(userId);
    }


    @Override
    public String Userlogin(LoginDTO loginDTO) {
        UserEntity userEntity = iUserRepository.findByEmailId(loginDTO.getUserEmail());
        if(userEntity != null) {
            String token = userJWT.generateToken(userEntity.getUserId());
            return "Logged in successfully" + token;
        }else{
            return "login failed";
        }
    }
}
