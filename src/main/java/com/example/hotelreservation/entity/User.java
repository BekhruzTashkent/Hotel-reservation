package com.example.hotelreservation.entity;

import com.example.hotelreservation.entity.template.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")

public class User extends IdClass {

    private String name;

    private String surname;

    private Integer phone;

    @Column(unique = true)
    private String email;

    private String password;

    private String country;

    private String city;

    private String address;

    private String zipcode;

    private boolean status = true;

}
