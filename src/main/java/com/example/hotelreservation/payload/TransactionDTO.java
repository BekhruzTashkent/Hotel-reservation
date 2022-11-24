package com.example.hotelreservation.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDTO {

        private Timestamp date;

        private String methodOfPayment;

        private Integer amount;

        private Integer bookingId;
        }
