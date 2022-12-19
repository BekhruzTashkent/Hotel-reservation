package com.example.hotelreservation.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class BookingDTO {

        private Timestamp start;

        @NotNull(message = "fill the blank")
        private String email;

        @Size(min = 4, message = "minimum size of password is 4")
        @NotNull(message = "fill the blank")
        private String password;

        private Integer userID;
        
        }

