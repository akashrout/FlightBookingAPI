package com.example.demo.flight.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.EnglishEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FlightEntity;
import com.example.demo.flight.service.FlightService;
import com.example.demo.repo.FlightRepository;

import ch.qos.logback.classic.pattern.MessageConverter;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository repository;

	@Override
	public boolean isFlightNumberPresent(String flightNumber) {
		// TODO Auto-generated method stub
		return repository.existsByFlightNumber(flightNumber);
	}

	@Override
	public List<FlightEntity> getavailableFlighrs(FlightEntity flightEntity) {
		// TODO Auto-generated method stub
	
		
		List<FlightEntity> allFlights = repository.findAll();
		System.out.println("Available Flights 1: " + allFlights);
		List<FlightEntity> availableFlights = new ArrayList<FlightEntity>();

		FlightEntity entity = new FlightEntity();
		entity.setArrivalDate(null);
		entity.setArrivalDate(null);
		List<FlightEntity> notavailableFlights = new ArrayList<FlightEntity>();
		notavailableFlights.add(entity);
		for (FlightEntity flightEntity2 : allFlights) {
		//	System.out.println("details: " + flightEntity.getArrivalDate() + "..." + flightEntity2.getArrivalDate());
			if ((flightEntity.getDepartureDate().isEqual(flightEntity2.getDepartureDate()))
					&& (flightEntity.getArrivalDate().isEqual(flightEntity2.getArrivalDate()))
					&& (flightEntity.getArrival().equals(flightEntity2.getArrival()))
					&& (flightEntity.getDeparture().equals(flightEntity2.getDeparture()))) {
				System.out.println();
				availableFlights.add(flightEntity2);

			}
		}
		System.out.println(availableFlights.size()+"..."+notavailableFlights.size());

		if (availableFlights.size() >= 1) {
			return availableFlights;
		} else {
			return null;
		}

	}

	@Override
	public List<FlightEntity> findByFlightNumber(String flightNumber) {
		// TODO Auto-generated method stub
		return repository.findByFlightNumber(flightNumber);
	}

	@Override
	public void deleteFlight(String flightNumber) {
		// TODO Auto-generated method stub
		repository.deleteFlightEntityByFlightNumber(flightNumber);
		
	}

}
