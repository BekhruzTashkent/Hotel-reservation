package com.example.hotelreservation.repository;


import com.example.hotelreservation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingByEmailAndPassword (String email, String password);
}
