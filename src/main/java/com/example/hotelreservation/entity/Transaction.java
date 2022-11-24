package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Transaction extends IdClass {

    private Timestamp date;

    private String methodOfPayment;

    private boolean status;

    private Integer amount;

    @ManyToOne
    private Booking booking;

}
