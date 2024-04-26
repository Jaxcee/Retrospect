package com.example.retrospect.createchatroom.service;

import com.example.retrospect.createchatroom.entity.CreateRoomEntity;
import com.example.retrospect.createchatroom.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RoomService implements IRoomService{

    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public List<CreateRoomEntity> getAllRooms() {

        return roomRepository.findAll();
    }

    @Override
    public CreateRoomEntity createRoom(CreateRoomEntity createRoomEntity) {
        return roomRepository.save(createRoomEntity);
    }
}
