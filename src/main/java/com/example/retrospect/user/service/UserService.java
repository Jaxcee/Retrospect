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
        // Create a new UserEntity instance
        UserEntity userEntity = new UserEntity();

        // Encrypt password
        String encryptedPassword = bCryptPasswordEncoder.encode(signUpDTO.getUserPassword());

        // Set properties
        userEntity.setUserEmail(signUpDTO.getUserEmail());
        userEntity.setUserName(signUpDTO.getUserName());
        userEntity.setUserPassword(encryptedPassword);
        userEntity.setUserRole(signUpDTO.getUserRole());

        // Save the userEntity
        iUserRepository.save(userEntity);

        return "You have been signed up successfully";
    }




    @Override
    public Optional<UserEntity> getUserByJWT(String token) {
        long userId = userJWT.decodeToken(token);
        System.out.println(" service" + userId);
        return iUserRepository.findByuserId(userId);
    }


    @Override
    public String Userlogin(LoginDTO loginDTO) {
        UserEntity userEntity = iUserRepository.findByEmailId(loginDTO.getUserEmail());
        if(userEntity != null && bCryptPasswordEncoder.matches(loginDTO.getUserPassword(), userEntity.getUserPassword())) {
            String token = userJWT.generateToken(userEntity.getUserId());
            return "Logged in successfully" + token;
        }else{
            return "login failed";
        }
    }
}
