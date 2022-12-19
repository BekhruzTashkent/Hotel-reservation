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

public class Booking extends IdClass {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "start")
    private Timestamp dateOfIssue;

    boolean isRoomBooked = true; //status

    @OneToOne
    User user;

}
