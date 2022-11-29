package com.example.hotelreservation.controller;

import com.example.hotelreservation.entity.Room;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.RoomDTO;
import com.example.hotelreservation.payload.RoomTypeDTO;
import com.example.hotelreservation.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Room> all = roomService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Room byId = roomService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody RoomDTO roomDTO){
        ApiResponse apiResponse = roomService.add(roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody RoomDTO roomDTO){
        ApiResponse apiResponse = roomService.update(id, roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = roomService.deleteRoom(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
