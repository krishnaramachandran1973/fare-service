package com.cts.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.domain.Fare;

public interface FareRepository extends JpaRepository<Fare, Long> {
	Fare findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);
}
