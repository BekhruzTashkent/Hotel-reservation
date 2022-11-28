package com.example.hotelreservation.service;


import com.example.hotelreservation.entity.Room;
import com.example.hotelreservation.entity.RoomType;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.RoomDTO;
import com.example.hotelreservation.repository.RoomRepository;
import com.example.hotelreservation.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    public Room getById(Integer id){
        Optional<Room> byId = roomRepository.findById(id);
        return byId.orElse(null);
    }

    public List<Room> findAll(){
       return roomRepository.findAll();
    }

    public ApiResponse add(RoomDTO roomDTO){

        Optional<RoomType> byId = roomTypeRepository.findById(roomDTO.getRoomTypeId());
        if(byId.isEmpty()){
            return new ApiResponse("no such roomtypeId", false);
        }

        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setDescription(room.getDescription());
        room.setFeatures(room.getFeatures());
        room.setRoomType(byId.get());

        return new ApiResponse("saved", true);

    }

    public ApiResponse update(Integer id, RoomDTO roomDTO){

        Optional<Room> byIdRoom = roomRepository.findById(id);
        if(byIdRoom.isEmpty()){
            return new ApiResponse("no such room", false);
        }

        Optional<RoomType> byId = roomTypeRepository.findById(roomDTO.getRoomTypeId());
        if(byId.isEmpty()){
            return new ApiResponse("no such roomtypeId", false);
        }

        Room room = byIdRoom.get();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setDescription(room.getDescription());
        room.setFeatures(room.getFeatures());
        room.setRoomType(byId.get());

        return new ApiResponse("saved", true);

    }

    public ApiResponse deleteRoom(Integer id){
        Optional<Room> byId = roomRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such roomType id", false);
        }

        roomRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }


}
