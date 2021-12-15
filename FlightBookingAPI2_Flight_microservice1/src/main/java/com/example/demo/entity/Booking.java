package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;

	private String fastName;

	private String lastName;

	private String email;

	private String mobile;

	private String gender;

	private String flightNumber;

	private String airlineName;

	private String departure;

	private String arrival;

	private String pnr;

	private String ticketstatus;

	private LocalDateTime departureDate;

	private LocalDateTime arrivalDate;

	public Booking() {

		// TODO Auto-generated constructor stub
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public String getFastName() {
		return fastName;
	}

	public void setFastName(String fastName) {
		this.fastName = fastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getTicketstatus() {
		return ticketstatus;
	}

	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
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


	public Booking(int bookingId, String fastName, String lastName, String email, String mobile, String gender,
			String flightNumber, String airlineName, String departure, String arrival, String pnr, String ticketstatus,
			LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.bookingId = bookingId;
		this.fastName = fastName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departure = departure;
		this.arrival = arrival;
		this.pnr = pnr;
		this.ticketstatus = ticketstatus;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", fastName=" + fastName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + ", gender=" + gender + ", flightNumber=" + flightNumber
				+ ", airlineName=" + airlineName + ", departure=" + departure + ", arrival=" + arrival + ", pnr=" + pnr
				+ ", ticketstatus=" + ticketstatus + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate
				+ "]";
	}

	

	
}