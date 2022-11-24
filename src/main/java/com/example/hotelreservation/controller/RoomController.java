package com.example.hotelreservation.controller;


import com.example.hotelreservation.entity.RoomType;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.RoomTypeDTO;
import com.example.hotelreservation.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roomType")
public class RoomController {

    @Autowired
    RoomTypeService roomTypeService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<RoomType> all = roomTypeService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody RoomTypeDTO roomTypeDTO){
        ApiResponse apiResponse = roomTypeService.addRoomType(roomTypeDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody RoomTypeDTO roomTypeDTO){
        ApiResponse apiResponse = roomTypeService.updateRoomType(id, roomTypeDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = roomTypeService.deleteRoomType(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
