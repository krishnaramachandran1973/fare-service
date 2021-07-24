package com.cts;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cts.domain.Fare;
import com.cts.repository.FareRepository;

import lombok.RequiredArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RequiredArgsConstructor

@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class FareServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(FareServiceApplication.class);

	private final FareRepository fareRepository;

	public static void main(String[] args) {
		SpringApplication.run(FareServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			Arrays.asList(Fare.builder()
					.flightNumber("BF100")
					.flightDate(LocalDate.of(2021, 8, 22))
					.amount("100")
					.build(),
					Fare.builder()
							.flightNumber("BF101")
							.flightDate(LocalDate.of(2021, 9, 18))
							.amount("101")
							.build(),
					Fare.builder()
							.flightNumber("BF102")
							.flightDate(LocalDate.of(2021, 10, 12))
							.amount("102")
							.build(),
					Fare.builder()
							.flightNumber("BF103")
							.flightDate(LocalDate.of(2021, 11, 05))
							.amount("103")
							.build(),
					Fare.builder()
							.flightNumber("BF104")
							.flightDate(LocalDate.of(2021, 12, 01))
							.amount("104")
							.build(),
					Fare.builder()
							.flightNumber("BF105")
							.flightDate(LocalDate.of(2021, 8, 16))
							.amount("105")
							.build(),
					Fare.builder()
							.flightNumber("BF106")
							.flightDate(LocalDate.of(2021, 8, 19))
							.amount("106")
							.build())
					.forEach(fare -> fareRepository.save(fare));
			logger.info("Result: "
					+ this.fareRepository.findByFlightNumberAndFlightDate("BF101", LocalDate.of(2021, 9, 18)));
		};
	}

}
