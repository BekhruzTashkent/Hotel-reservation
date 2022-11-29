package com.example.hotelreservation.controller;

import com.example.hotelreservation.entity.User;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.UserDTO;
import com.example.hotelreservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<User> all = userService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody UserDTO userDTO){
        ApiResponse apiResponse = userService.addUser(userDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        ApiResponse apiResponse = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = userService.deleteUser(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
