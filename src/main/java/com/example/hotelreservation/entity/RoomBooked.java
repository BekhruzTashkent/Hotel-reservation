package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class RoomBooked extends IdClass {

    private boolean currentStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    @Column(name = "dateFrom")
    private Timestamp dateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    @Column(name = "dateTo")
    private Timestamp dateTo;


    @OneToOne
    private Booking booking;

    @OneToOne
    private Room room;

}
