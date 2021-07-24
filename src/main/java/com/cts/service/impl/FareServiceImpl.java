package com.cts.service.impl;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.domain.Fare;
import com.cts.repository.FareRepository;
import com.cts.service.FareService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FareServiceImpl implements FareService {

	private final Logger logger = LoggerFactory.getLogger(FareServiceImpl.class);

	private final FareRepository fareRepository;

	@Override
	public Fare getFare(String flightNumber, LocalDate flightDate) {
		logger.info("Looking for fares flightNumber " + flightNumber + " flightDate " + flightDate);
		return this.fareRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}
}
