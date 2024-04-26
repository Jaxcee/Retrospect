package com.example.retrospect.user.repository;

import com.example.retrospect.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository <UserEntity, Integer> {
  @Query("SELECT u FROM UserEntity u WHERE u.userEmail = :email")
    UserEntity findByEmailId(@Param("email") String email);

  Optional<UserEntity> findByuserId(Long userId);
}
