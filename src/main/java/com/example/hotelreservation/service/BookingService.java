package com.example.hotelreservation.service;

import com.example.hotelreservation.entity.Booking;
import com.example.hotelreservation.entity.User;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.BookingDTO;
import com.example.hotelreservation.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookingService {
    
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserService userService;
    
    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }

    public Booking getById(Integer id){
        Optional<Booking> byId = bookingRepository.findById(id);
        return byId.orElse(null);
    }
    
    public ApiResponse addBooking(BookingDTO bookingDto){

        Optional<User> userById = Optional.ofNullable(userService.findById(bookingDto.getUserID()));


        Booking booking = new Booking();
        booking.setDateOfIssue(bookingDto.getDateOfIssue());
        booking.setUser(userById.get());
        bookingRepository.save(booking);

        return new ApiResponse("added", true);

    }

    public ApiResponse updateBooking(Integer id, BookingDTO bookingDto){

        Optional<User> userById = Optional.ofNullable(userService.findById(bookingDto.getUserID()));

        Optional<Booking> byId = bookingRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such booking id", false);
        }

        Booking booking = byId.get();
        booking.setDateOfIssue(bookingDto.getDateOfIssue());
        booking.setUser(userById.get());
        bookingRepository.save(booking);

        return new ApiResponse("updated", true);

    }

    public ApiResponse deleteBooking(Integer id){
        Optional<Booking> byId = bookingRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such booking id", false);
        }

        bookingRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }
    
}
