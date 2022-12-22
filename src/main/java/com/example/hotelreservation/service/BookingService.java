package com.example.hotelreservation.service;

import com.example.hotelreservation.entity.Booking;

import com.example.hotelreservation.entity.RoomBooked;
import com.example.hotelreservation.entity.User;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.BookingDTO;
import com.example.hotelreservation.repository.BookingRepository;
import com.example.hotelreservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookingService {
    
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;
    
    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }

    public Booking getById(Integer id){
        Optional<Booking> byId = bookingRepository.findById(id);
        return byId.orElse(null);
    }
    
    public ApiResponse addBooking(@Valid BookingDTO bookingDto){

        try {
            Optional<User> byPasswordAndEmail =
                    userRepository.findByPasswordAndEmail(bookingDto.getPassword(), bookingDto.getEmail());
            if (byPasswordAndEmail.isEmpty()) {
                return new ApiResponse("password or email error", false);
            }



            Booking booking = new Booking();
            booking.setDateOfIssue(bookingDto.getStart());
            booking.setUser(byPasswordAndEmail.get());
            bookingRepository.save(booking);

            return new ApiResponse("added", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ApiResponse updateBooking(Integer id,@Valid BookingDTO bookingDto){


        try {
            Optional<Booking> byId = bookingRepository.findById(id);
            if (byId.isEmpty()) {
                return new ApiResponse("no such booking id", false);
            }

            Optional<User> byPasswordAndEmail =
                    userRepository.findByPasswordAndEmail(bookingDto.getPassword(), bookingDto.getEmail());
            if (byPasswordAndEmail.isEmpty()) {
                return new ApiResponse("password or email error", false);
            }

            Booking booking = byId.get();
            booking.setDateOfIssue(bookingDto.getStart());
            booking.setUser(byPasswordAndEmail.get());
            bookingRepository.save(booking);


            return new ApiResponse("updated", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ApiResponse deleteBooking(Integer id){
        Optional<Booking> byId = bookingRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such booking id", false);
        }

        bookingRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }//i am

    public List<Booking> getByEmailAndPassword(String email, String password) {
        List<Booking> bookingByEmailAndPassword = bookingRepository.findBookingByEmailAndPassword(email, password);
        if(bookingByEmailAndPassword.isEmpty()){
            return null;
        }
        return bookingByEmailAndPassword;
    }
}
