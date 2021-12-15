package com.example.demo.flight.service;

import java.util.List;

import com.example.demo.entity.Booking;

public interface BookingService {

	public Booking getBookingData(Booking booking);

	public boolean isPnrNumberPresent(String pnrNumber);

	public Booking getPNRBookingData(String pnrNo);
	
	public List<Booking> getEmailBookingData(String email);
	
	public boolean isBookingEmailPresent(String email);
	
	public Booking cancelFlightTicket(int bookingId);

}
