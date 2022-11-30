package com.example.hotelreservation.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RoomBookedDTO {

        private Timestamp dateFrom;
        //dto class
        private Timestamp dateTo;

        private Integer bookingId;

        private Integer roomId;
        
        }
