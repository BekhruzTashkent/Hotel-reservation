package com.example.hotelreservation.payload;

import com.sun.istack.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDTO {

        private Timestamp date;

        private String methodOfPayment;

        private Integer amount;

        private Integer bookingId;

        }
