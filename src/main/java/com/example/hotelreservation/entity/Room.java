package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Room extends IdClass {

    private Integer roomNumber;

    private String description;

    private String features;

    @ManyToOne
    RoomType roomType;

}
