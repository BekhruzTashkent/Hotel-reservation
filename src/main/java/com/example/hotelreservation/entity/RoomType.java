package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class RoomType extends IdClass {

    private String name;
}
