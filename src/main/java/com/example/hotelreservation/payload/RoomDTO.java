package com.example.hotelreservation.payload;

import lombok.Data;

@Data
public class RoomDTO {

        //room

        private Integer roomNumber;

        private String description;

        private String features;

        private Integer roomTypeId;
        
        }
