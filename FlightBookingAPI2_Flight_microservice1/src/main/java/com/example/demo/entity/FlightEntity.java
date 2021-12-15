package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightEntity.
 */
@Entity
public class FlightEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flightId;
	
	private String flightNumber;

	private String airlineName;

	private String departure;

	private String arrival;

//	@JsonFormat(pattern = "YYYY-MM-ddTHH:mm:ss")
	private LocalDateTime departureDate;

//	@JsonFormat(pattern = "YYYY-MM-ddTHH:mm:ss")
	private LocalDateTime arrivalDate;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	

	public FlightEntity(Long flightId, String flightNumber, String airlineName, String departure, String arrival,
			LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}
	
	

	public FlightEntity(String flightNumber, String airlineName, String departure, String arrival,
			LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public FlightEntity() {
		super();
	}

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", airlineName=" + airlineName + ", departure=" + departure
				+ ", arrival=" + arrival + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
	}

}
