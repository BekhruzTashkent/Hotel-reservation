package com.example.hotelreservation.service;


import com.example.hotelreservation.entity.Room;
import com.example.hotelreservation.entity.RoomBooked;
import com.example.hotelreservation.entity.Booking;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.RoomBookedDTO;
import com.example.hotelreservation.repository.BookingRepository;
import com.example.hotelreservation.repository.RoomBookedRepository;
import com.example.hotelreservation.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomBookedService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomBookedRepository roomBookedRepository;

    public RoomBooked getById(Integer id){
        Optional<RoomBooked> byId = roomBookedRepository.findById(id);
        return byId.orElse(null);
    }

    public List<RoomBooked> findAll(){
       return roomBookedRepository.findAll();
    }

    public ApiResponse add(RoomBookedDTO roomBookedDTO){

        Optional<Booking> byId = bookingRepository.findById(roomBookedDTO.getBookingId());
        if(byId.isEmpty()){
            return new ApiResponse("no such bookingId", false);
        }

        Optional<Room> byId1 = roomRepository.findById(roomBookedDTO.getRoomId());
        if(byId1.isEmpty()){
            return new ApiResponse("no such room id", false);
        }

        RoomBooked roomBooked = new RoomBooked();
        roomBooked.setDateFrom(roomBookedDTO.getDateFrom());
        roomBooked.setDateTo(roomBookedDTO.getDateTo());
        roomBooked.setBooking(byId.get());
        roomBooked.setRoom(byId1.get());
        roomBookedRepository.save(roomBooked);

        return new ApiResponse("saved", true);

    }

    public ApiResponse update(Integer id, RoomBookedDTO roomBookedDTO){

        Optional<RoomBooked> byIdRoom = roomBookedRepository.findById(id);
        if(byIdRoom.isEmpty()){
            return new ApiResponse("no such roomBooked", false);
        }

        Optional<Booking> byId = bookingRepository.findById(roomBookedDTO.getBookingId());
        if(byId.isEmpty()){
            return new ApiResponse("no such booking Id", false);
        }

        Optional<Room> byId1 = roomRepository.findById(roomBookedDTO.getRoomId());
        if(byId1.isEmpty()){
            return new ApiResponse("no such room id", false);
        }

        RoomBooked roomBooked = byIdRoom.get();
        roomBooked.setDateFrom(roomBookedDTO.getDateFrom());
        roomBooked.setDateTo(roomBookedDTO.getDateTo());
        roomBooked.setBooking(byId.get());
        roomBooked.setRoom(byId1.get());
        roomBookedRepository.save(roomBooked);

        return new ApiResponse("saved", true);

    }

    public ApiResponse deleteRoom(Integer id){
        Optional<RoomBooked> byId = roomBookedRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such roomBooked id", false);
        }

        roomBookedRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }


}
