package com.example.hotelreservation.repository;


import com.example.hotelreservation.entity.RoomBooked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookedRepository extends JpaRepository<RoomBooked, Integer> {
}
