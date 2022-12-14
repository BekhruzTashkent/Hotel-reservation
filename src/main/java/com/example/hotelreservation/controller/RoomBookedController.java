package com.example.hotelreservation.controller;

import com.example.hotelreservation.entity.RoomBooked;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.RoomBookedDTO;
import com.example.hotelreservation.projection.RoomBookedProjection;
import com.example.hotelreservation.service.RoomBookedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room_booked")
public class RoomBookedController {
    @Autowired
    RoomBookedService roomBookedService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<RoomBooked> all = roomBookedService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        RoomBooked roomBooked = roomBookedService.getById(id);
        return new ResponseEntity<>(roomBooked, HttpStatus.OK);
    }

//    @GetMapping("/getDateFrom")
//    public HttpEntity<?> getDateFrom(){
//        List<RoomBookedProjection> allRoomsInterval = roomBookedService.getAllRoomsInterval();
//        return new ResponseEntity<>(allRoomsInterval, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody RoomBookedDTO roomBookedDTO){
        ApiResponse apiResponse = roomBookedService.add(roomBookedDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @PostMapping("/secondAdd")
//    public HttpEntity<?> addSecond(@RequestBody RoomBookedDTO roomBookedDTO){
//        ApiResponse apiResponse = roomBookedService.secondAdd(roomBookedDTO);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody RoomBookedDTO roomBookedDTO){
        ApiResponse apiResponse = roomBookedService.update(id, roomBookedDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = roomBookedService.deleteRoom(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //---//

//    @GetMapping("/getRoomByDate/{dateFrom}")
//    public HttpEntity<?> getRoomByDate(@RequestBody Timestamp dateFrom, @RequestBody Timestamp dateTo){
//        roomBookedService.findRoomByDate(dateFrom, dateTo);
//        return null;
//    }

    @PostMapping("/getRoomByDate")
    public HttpEntity<?> getRoomByDate(@RequestBody RoomBookedDTO roomBookedDTO){
        List<RoomBooked> availableRooms = roomBookedService.findRoomByDate(roomBookedDTO.getDateFrom(), roomBookedDTO.getDateTo());
        return new ResponseEntity<>(availableRooms, HttpStatus.OK);
    }
}
