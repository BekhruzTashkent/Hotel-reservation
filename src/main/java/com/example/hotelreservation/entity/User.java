package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")

public class User extends IdClass {

    private String name;

    private String surname;

    private Integer phone;

    private String email;

    private String country;

    private String city;

    private String address;

    private String zipcode;

    private boolean status;

}
