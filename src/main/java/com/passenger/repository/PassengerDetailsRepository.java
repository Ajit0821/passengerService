package com.passenger.repository;

import com.passenger.entity.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails,Long> {
}
