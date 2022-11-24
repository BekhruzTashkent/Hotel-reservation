package com.example.hotelreservation.payload;

import lombok.Data;

@Data
public class RoomDTO {

        private Integer roomNumber;

        private String description;

        private String features;

        private Integer roomTypeId;
        
        }
