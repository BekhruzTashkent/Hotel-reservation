package com.example.hotelreservation.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BookingDTO {

        private Timestamp dateOfIssue;

        private Integer userID;
        
        }

