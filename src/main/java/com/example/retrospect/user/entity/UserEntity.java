package com.example.retrospect.user.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
@Table(name = "userTabel")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column
    private long userId;
    @Column
    private String userName;
    @Column
    private String userEmail;
    @Column
    private String userPassword;
    @Column
    private String userRole;





}
