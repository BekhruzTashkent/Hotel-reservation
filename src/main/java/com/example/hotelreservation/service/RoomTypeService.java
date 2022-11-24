package com.example.hotelreservation.service;

import com.example.hotelreservation.entity.RoomType;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.RoomTypeDTO;
import com.example.hotelreservation.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class RoomTypeService {
    
    @Autowired
    RoomTypeRepository roomTypeRepository;
    
    public List<RoomType> getAll(){
        return roomTypeRepository.findAll();
    }
    
    public ApiResponse addRoomType(RoomTypeDTO roomTypeDTO){

        RoomType roomType = new RoomType();
        roomType.setName(roomTypeDTO.getName());
        roomTypeRepository.save(roomType);

        return new ApiResponse("added", true);

    }

    public ApiResponse updateRoomType(Integer id, RoomTypeDTO roomTypeDTO){

        Optional<RoomType> byId = roomTypeRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such roomType id", false);
        }

        RoomType roomType = byId.get();
        roomType.setName(roomTypeDTO.getName());
        roomTypeRepository.save(roomType);

        return new ApiResponse("updated", true);

    }

    public ApiResponse deleteRoomType(Integer id){
        Optional<RoomType> byId = roomTypeRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such roomType id", false);
        }

        roomTypeRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }
    
}
