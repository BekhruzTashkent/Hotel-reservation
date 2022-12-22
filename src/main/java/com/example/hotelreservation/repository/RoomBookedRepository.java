package com.example.hotelreservation.repository;


import com.example.hotelreservation.entity.RoomBooked;
import com.example.hotelreservation.projection.RoomBookedProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomBookedRepository extends JpaRepository<RoomBooked, Integer> {

//    @Query(value = "select a from AttachmentContentMainWindow a where a.attachmentMainWindow.id = ?1 ")
//    Optional<AttachmentContentMainWindow> findByAttachmentId(Integer attachment_partners_id);


//    Timestamp findByDateFrom();
//
//    List<RoomBooked> findDateFrom();
//
//    Optional<RoomBooked> findAllByDateTo();

//    @Query(
//            value = "select " +
//                    "rm.dateFrom    as dateFrom, " +
//                    "rm.dateTo      as dateTo " +
//                    "from room_booked rm"
//    )
//    List<RoomBookedProjection> getAllDates();
//    RoomBooked findByDateFromAAndDateTo(Timestamp dateFromUser, Timestamp dateToUser);

//    @Query(
//            value = "select rm.dateFrom from room_booked rm"
//    )
//    List<Timestamp> getDateFrom();
//
//    @Query(
//            value = "select rm.dateTo from room_booked rm"
//    )
//    List<Timestamp> getDateTo();

    @Query(
            value = "select rm.dateFrom, rm.dateTo from room_booked rm"
    )
    List<RoomBooked> getDate();
}