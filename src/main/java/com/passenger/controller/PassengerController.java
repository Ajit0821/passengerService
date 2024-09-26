package com.passenger.controller;

import com.passenger.entity.PassengerDetails;
import com.passenger.payload.PassengerDetailsResponse;
import com.passenger.payload.PassengerDto;
import com.passenger.service.PassengerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PassengerController {

    @Autowired
    private PassengerDetailsService passengerDetailsService;

    @PostMapping("/passenger-details")
    public ResponseEntity<PassengerDto> createCategory( @RequestBody PassengerDetails passengerDetails){
        PassengerDto savedDetails = passengerDetailsService.savePassengerDetails(passengerDetails);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }
    @GetMapping("/passenger-details")
    public ResponseEntity<PassengerDetailsResponse> getAllDriversDetails() {
        PassengerDetailsResponse response = passengerDetailsService.getAllDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/passenger-details/{passengerId}")
    public ResponseEntity<PassengerDto> getDriverDetails(@PathVariable Long passengerId)  {
        PassengerDto details = passengerDetailsService.getPassengerDetailsById(passengerId);
        return new ResponseEntity<>(details,HttpStatus.OK);
    }
    @DeleteMapping("/passenger-details/{passengerId}")
    public ResponseEntity<PassengerDto> deletePassengerDetails(@PathVariable Long passengerId){
        PassengerDto deltetedPassengerDeatails = passengerDetailsService.deletePassengerDetailsById(passengerId);
        return (new ResponseEntity<>(deltetedPassengerDeatails, HttpStatus.OK));
    }
    @PutMapping("/passenger-details/{passengerId}")
    public ResponseEntity<PassengerDto> updatePassengerDetails(@RequestBody PassengerDetails passengerDetails,
                                                            @PathVariable Long passengerId){
        PassengerDto updatedDetails = passengerDetailsService.updatePassengerDetails(passengerDetails, passengerId);
        return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
    }
}
