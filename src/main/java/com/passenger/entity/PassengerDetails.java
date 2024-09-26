package com.passenger.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "passenger_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long passengerId;
    @NotBlank
    @Column(name = "passenger_name")
    private String passengerName;
    @NotBlank
    @Column(name = "passenger_contact_number")
    private  String passengerContactNumber;
}
