package com.example.hotelreservation.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookedDTO {

        @JsonProperty("dateFrom")
        private Timestamp dateFrom;

        @JsonProperty("dateFrom")
        private Timestamp dateTo;

        @JsonProperty("dateFrom")
        private Integer bookingId;

        @JsonProperty("dateFrom")
        private Integer roomId;
        
}
