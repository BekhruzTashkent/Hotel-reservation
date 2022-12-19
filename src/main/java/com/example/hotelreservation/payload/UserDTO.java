package com.example.hotelreservation.payload;



import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {


        private String name;

        private String surname;

        private Integer phone;

        @Column(unique = true)
        @NotNull(message = "fill the blank")
        @NotBlank()
        @Email
        private String email;

        @Size(min =4 , message = "minimum 4 chars")
        @NotNull(message = "fill the blank")
        @NotBlank
        private String password;

        private String country;

        private String city;

        private String address;

        private String zipcode;
        
        }
