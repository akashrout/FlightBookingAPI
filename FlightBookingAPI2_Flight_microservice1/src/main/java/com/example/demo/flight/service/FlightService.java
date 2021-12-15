package com.example.demo.flight.service;

import java.util.List;

import com.example.demo.entity.FlightEntity;

public interface FlightService {
	
	public boolean isFlightNumberPresent(String flightNumber);
	
	public List<FlightEntity> getavailableFlighrs(FlightEntity flightEntity);
	
	public List<FlightEntity> findByFlightNumber(String flightNumber);
	
	public void deleteFlight(String flightNumber);

}
