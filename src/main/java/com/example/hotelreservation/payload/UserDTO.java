package com.example.hotelreservation.payload;

import lombok.Data;

@Data
public class UserDTO {


        private String name;

        private String surname;

        private Integer phone;

        private String email;

        private String country;

        private String city;

        private String address;

        private String zipcode;
        
        }
