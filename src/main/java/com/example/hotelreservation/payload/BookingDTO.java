package com.example.hotelreservation.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BookingDTO {

        private Timestamp start;

        private Integer userID;
        
        }

