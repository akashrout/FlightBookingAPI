package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Status;
import com.example.demo.entity.Booking;
import com.example.demo.entity.FlightEntity;
import com.example.demo.flight.service.BookingService;
import com.example.demo.flight.service.FlightService;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.FlightRepository;
import com.example.demo.ticket.PNRGenerator;
import com.example.demo.validation.FlightValidator;

@RestController
@RequestMapping("/api/v1.0")
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightValidator flightValidator;

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private BookingService bookingService;

	@GetMapping("/getall")
	public ResponseEntity<List<FlightEntity>> getAllFlights() {
		List<FlightEntity> flightEntities = flightRepository.findAll();
		if (flightEntities.isEmpty()) {
			return new ResponseEntity<>(flightEntities, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(flightEntities, HttpStatus.OK);

	}

	@PostMapping("/airlines")
	public ResponseEntity<FlightEntity> addFlight(@RequestBody FlightEntity flightEntity) {

		if (flightValidator.validateFlightForEmptyData(flightEntity)) {
			if (flightValidator.isFlightNumberPresent(flightEntity.getFlightNumber())) {
				return new ResponseEntity(
						new Status("Flight number " + flightEntity.getFlightNumber() + " is already present...."),
						HttpStatus.NOT_ACCEPTABLE);
			} else {
				FlightEntity entity = flightRepository.save(flightEntity);
				return new ResponseEntity<>(flightEntity, HttpStatus.CREATED);
			}

		} else {
			return new ResponseEntity(new Status("Unable to create. Some fields are missing "), HttpStatus.CONFLICT);
		}

	}

	@PostMapping("/flight/search")
	public ResponseEntity<FlightEntity> searchFlight(@RequestBody FlightEntity flightEntity) {

		if (flightValidator.validateSearchFlightForEmptyData(flightEntity)) {
			List<FlightEntity> entities = flightService.getavailableFlighrs(flightEntity);
			// System.out.println("sizeeeeeeee: "+entities.size());

			if (entities != null) {
				List<FlightEntity> availableFlights = flightService.getavailableFlighrs(flightEntity);
				return new ResponseEntity(availableFlights, HttpStatus.OK);
			} else {
				return new ResponseEntity(new Status("Unable to search, please search for other dates "),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			return new ResponseEntity(new Status("Unable to search. Some fields are missing "), HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/flight/search/{flightNumber}")
	public ResponseEntity<FlightEntity> searchFlightByNumber(@PathVariable("flightNumber") String flightNo) {
		if (flightValidator.isFlightNumberPresent(flightNo)) {
			List<FlightEntity> flightEntities = flightService.findByFlightNumber(flightNo);

			return new ResponseEntity(flightEntities, HttpStatus.OK);
		} else {
			return new ResponseEntity(new Status("No Flifht Found "), HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/flight/delete/{flightNumber}")
	public ResponseEntity<FlightEntity> deleteFlightByNumber(@PathVariable("flightNumber") String flightNo) {
		if (flightValidator.isFlightNumberPresent(flightNo)) {

			flightService.deleteFlight(flightNo);
			return new ResponseEntity(new Status("Flight Deleted Successfully.. "), HttpStatus.OK);
		} else {
			return new ResponseEntity(new Status("No Flifht Found "), HttpStatus.CONFLICT);
		}
	}

	
}
