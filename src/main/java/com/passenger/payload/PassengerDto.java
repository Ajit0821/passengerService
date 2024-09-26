package com.passenger.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long passengerId;
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "passenger_contact_number")
    private  String passengerContactNumber;
}
