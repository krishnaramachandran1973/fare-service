package com.cts.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.domain.Fare;
import com.cts.errors.FareError;
import com.cts.service.FareService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fare")
public class FareController {
	private final Logger logger = LoggerFactory.getLogger(FareController.class);

	private final FareService fareService;

	@GetMapping
	public ResponseEntity<Fare> getFare(@RequestParam(value = "flightNumber") String flightNumber,
			@RequestParam(value = "flightDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate flightDate,
			@RequestHeader("Gateway") String header) {
		logger.info("Searching fare with flightNumber: {} and flightDate: {}", flightNumber, flightDate);
		logger.info("Header added {}", header);
		Fare fare = this.fareService.getFare(flightNumber, flightDate);
		return fare != null ? ResponseEntity.ok(fare)
				: ResponseEntity.notFound()
						.build();
	}

	@ExceptionHandler
	public ResponseEntity<FareError> handleException(Exception e) {
		return ResponseEntity.badRequest()
				.body(FareError.builder()
						.message(e.getLocalizedMessage())
						.build());
	}
}
