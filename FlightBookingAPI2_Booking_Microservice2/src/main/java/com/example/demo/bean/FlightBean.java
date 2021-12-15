package com.example.demo.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightBean.
 */
public class FlightBean {

	private Long flightId;

	private String airlineName;

	private String departure;

	private String arrival;

	private LocalDateTime departureDate;

	private LocalDateTime arrivalDate;

	public FlightBean() {
		super();
	}

	public FlightBean(Long flightId, String airlineName, String departure, String arrival, LocalDateTime departureDate,
			LocalDateTime arrivalDate) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

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

	@Override
	public String toString() {
		return "FlightBean [flightId=" + flightId + ", airlineName=" + airlineName + ", departure=" + departure
				+ ", arrival=" + arrival + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
	

}
