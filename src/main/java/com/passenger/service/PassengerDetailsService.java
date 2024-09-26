package com.passenger.service;

import com.passenger.entity.PassengerDetails;
import com.passenger.payload.PassengerDetailsResponse;
import com.passenger.payload.PassengerDto;

public interface PassengerDetailsService {
    PassengerDto savePassengerDetails(PassengerDetails passengerDetails);

    PassengerDetailsResponse getAllDetails();

    PassengerDto getPassengerDetailsById(Long passengerId);

    PassengerDto deletePassengerDetailsById(Long passengerId);

    PassengerDto updatePassengerDetails(PassengerDetails passengerDetails, Long passengerId);
}
