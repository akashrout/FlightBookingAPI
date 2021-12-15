package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FlightEntity;
import com.example.demo.flight.service.FlightService;

@Service
public class FlightValidator {

	@Autowired
	private FlightService flightService;

	public boolean isFlightNumberPresent(String flightNumber) {
		if (flightService.isFlightNumberPresent(flightNumber)) {
			return true;

		} else {
			return false;
		}
	}

	public boolean validateFlightForEmptyData(FlightEntity entity) {

		if (entity.getAirlineName() == null || entity.getArrival() == null || entity.getArrivalDate() == null
				|| entity.getDeparture() == null || entity.getDepartureDate() == null
				|| entity.getFlightNumber() == null) {
			return false;

		} else {
			return true;
		}
	}

	public boolean validateSearchFlightForEmptyData(FlightEntity entity) {

		if (entity.getArrivalDate() == null || entity.getDepartureDate() == null || entity.getDeparture() == null
				|| entity.getArrival() == null) {

			return false;

		} else {
			return true;

		}

	}

}
