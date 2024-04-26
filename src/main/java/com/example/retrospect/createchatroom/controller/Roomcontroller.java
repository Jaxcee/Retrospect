package com.example.retrospect.createchatroom.controller;

import com.example.retrospect.createchatroom.entity.CreateRoomEntity;
import com.example.retrospect.createchatroom.repository.IRoomRepository;
import com.example.retrospect.createchatroom.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Roomcontroller {
    @Autowired
    IRoomService iRoomService;

    @Autowired
    IRoomRepository iRoomRepository;

    @GetMapping("/rooms")
    List<CreateRoomEntity> getAllRooms(){
        return iRoomService.getAllRooms();
    }


    @PostMapping("/addrooms")

    CreateRoomEntity createRoom(@RequestBody CreateRoomEntity createRoomEntity){
        return iRoomService.createRoom(createRoomEntity);
    }
}
