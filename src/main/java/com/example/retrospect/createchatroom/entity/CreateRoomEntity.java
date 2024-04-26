package com.example.retrospect.createchatroom.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="RoomDetails")
public class CreateRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;
    private String roomName;
    private String roomDescription;
    private String roomType;
    private String roomStatus;
    private String createdBy;

}
