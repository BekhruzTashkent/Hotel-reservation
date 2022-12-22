package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Transaction extends IdClass {

    @Column(nullable = false)
    private Timestamp date;

    private String methodOfPayment;

    private boolean status = true;

    private Integer amount;

    @ManyToOne
    private Booking booking;

}
