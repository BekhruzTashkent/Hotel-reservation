package com.example.hotelreservation.controller;

import com.example.hotelreservation.entity.Booking;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.BookingDTO;
import com.example.hotelreservation.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Booking> all = bookingService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Booking booking = bookingService.getById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody BookingDTO bookingDTO){
        ApiResponse apiResponse = bookingService.addBooking(bookingDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody BookingDTO bookingDTO){
        ApiResponse apiResponse = bookingService.updateBooking(id, bookingDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = bookingService.deleteBooking(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
