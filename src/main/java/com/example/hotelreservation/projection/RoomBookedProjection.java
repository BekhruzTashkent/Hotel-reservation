package com.example.hotelreservation.projection;

import java.sql.Timestamp;

public interface RoomBookedProjection {

    Timestamp dateFrom();

    Timestamp dateTo();

}
