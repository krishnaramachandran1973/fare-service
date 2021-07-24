package com.cts.service;

import java.time.LocalDate;

import com.cts.domain.Fare;

public interface FareService {
	public Fare getFare(String flightNumber, LocalDate flightDate);

}
