package com.passenger.service;

import com.passenger.entity.PassengerDetails;
import com.passenger.exception.DataNotFoundException;
import com.passenger.payload.PassengerDetailsResponse;
import com.passenger.payload.PassengerDto;
import com.passenger.repository.PassengerDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerDetailsServiceImpl implements PassengerDetailsService {
    @Autowired
    private PassengerDetailsRepository passengerDetailsRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public PassengerDto savePassengerDetails(PassengerDetails passengerDetails) {
        passengerDetailsRepository.save(passengerDetails);
        return modelMapper.map(passengerDetails,PassengerDto.class);
    }

    @Override
    public PassengerDetailsResponse getAllDetails() {
        List<PassengerDetails> passengerDetailsList = passengerDetailsRepository.findAll();
        List<PassengerDto> passengerDtoList = passengerDetailsList.stream().map(passengerDetails -> modelMapper.map(passengerDetails,PassengerDto.class)).toList();
        PassengerDetailsResponse passengerDetailsResponse = new PassengerDetailsResponse();
        passengerDetailsResponse.setPassengerDtoList(passengerDtoList);
        return passengerDetailsResponse;
    }

    @Override
    public PassengerDto getPassengerDetailsById(Long passengerId) {
        Optional<PassengerDetails> passengerDetails = Optional.ofNullable(passengerDetailsRepository.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException(String.format("Passenger details with id %s not found ",passengerId))));
        return modelMapper.map(passengerDetails,PassengerDto.class);
    }

    @Override
    public PassengerDto deletePassengerDetailsById(Long passengerId) {
        Optional<PassengerDetails> passengerDetails = Optional.ofNullable(passengerDetailsRepository.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException(String.format("Passenger details with id %s not found ",passengerId))));
        passengerDetailsRepository.deleteById(passengerId);
        return modelMapper.map(passengerDetails,PassengerDto.class);
    }

    @Override
    public PassengerDto updatePassengerDetails(PassengerDetails passengerDetails, Long passengerId) {
        Optional<PassengerDetails> fetchedDetails = Optional.ofNullable(passengerDetailsRepository.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException(String.format("Passenger details with id %s not found ",passengerId))));
        passengerDetailsRepository.save(passengerDetails);
        return modelMapper.map(passengerDetails,PassengerDto.class);
    }
}
