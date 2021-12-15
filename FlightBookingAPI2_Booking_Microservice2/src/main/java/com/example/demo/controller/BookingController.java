package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.validation.BookingValidator;
import com.example.demo.validation.FlightValidator;

@RestController
@RequestMapping("/api/v1.0")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightValidator flightValidator;

	@Autowired
	private FlightService flightService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingValidator bookingValidator;

	@PostMapping("/flight/search/booking/{flightid}")
	public ResponseEntity<FlightEntity> searchFlight(@RequestBody Booking booking,
			@PathVariable("flightid") String flightNo) {

		if (flightValidator.isFlightNumberPresent(flightNo)) {

			FlightEntity entity = new FlightEntity(booking.getFlightNumber(), booking.getAirlineName(),
					booking.getDeparture(), booking.getArrival(), booking.getDepartureDate(), booking.getArrivalDate());

			List<FlightEntity> entities = flightService.getavailableFlighrs(entity);
			// System.out.println("sizeeeeeeee: "+entities.size());

			if (entities != null) {
				List<FlightEntity> availableFlights = flightService.getavailableFlighrs(entity);

				Booking bookingdetails = bookingService.getBookingData(booking);

				//System.out.println("Inserted Details are: " + booking);
				//System.out.println("booking Details are: " + bookingdetails);
				bookingRepository.save(bookingdetails);

				return new ResponseEntity(bookingdetails, HttpStatus.OK);
			} else {
				return new ResponseEntity(new Status("Unable to search, please search for other dates "),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			return new ResponseEntity(new Status("No Flifht Found "), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/flight/ticket/pnr/{pnr}")
	public ResponseEntity<FlightEntity> searchFlightBasedOnPNR(@PathVariable("pnr") String pnrNo) {

		if (bookingValidator.isPNRPresent(pnrNo)) {
			Booking bookingDetails = bookingService.getPNRBookingData(pnrNo);
			
			

			return new ResponseEntity(bookingDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity(new Status("PNR number not Found Found "), HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/flight/ticket/email/{emailId}")
	public ResponseEntity<FlightEntity> searchFlightbasedOnEmailId(@PathVariable("emailId") String emailId) {

		if (bookingValidator.isEmailPresent(emailId)) {
			List<Booking> bookingDetails = bookingService.getEmailBookingData(emailId);

			return new ResponseEntity(bookingDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity(new Status("Tickets not Found Found, please enter a valid email "),
					HttpStatus.CONFLICT);
		}

	}
	
	@DeleteMapping("/flight/cancel/{pnr}")
	public ResponseEntity<FlightEntity> cancelFlightBasedOnPNR(@PathVariable("pnr") String pnrNo) {
		if (bookingValidator.isPNRPresent(pnrNo)) {
			Booking cancelledTic = bookingService.getPNRBookingData(pnrNo);
			Booking cancelledDetails = bookingService.cancelFlightTicket(cancelledTic.getBookingId());

			return new ResponseEntity(cancelledDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity(new Status("PNR number not Found Found "), HttpStatus.CONFLICT);
		}

		
	}


}
