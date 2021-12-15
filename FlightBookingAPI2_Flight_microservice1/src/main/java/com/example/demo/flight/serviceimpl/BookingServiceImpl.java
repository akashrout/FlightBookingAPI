package com.example.demo.flight.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.flight.service.BookingService;
import com.example.demo.repo.BookingRepository;
import com.example.demo.ticket.PNRGenerator;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking getBookingData(Booking booking) {
		// TODO Auto-generated method stub
		String pnrNumber = PNRGenerator.getPNRNumber();

		Booking booking2 = new Booking();
		booking2.setAirlineName(booking.getAirlineName());
		booking2.setFlightNumber(booking.getFlightNumber());
		booking2.setFastName(booking.getFastName());
		booking2.setLastName(booking.getLastName());
		booking2.setArrival(booking.getArrival());
		booking2.setDeparture(booking.getDeparture());
		booking2.setDepartureDate(booking.getDepartureDate());
		booking2.setArrivalDate(booking.getArrivalDate());
		booking2.setMobile(booking.getMobile());
		booking2.setEmail(booking.getEmail());
		booking2.setGender(booking.getGender());
		booking2.setPnr(pnrNumber);
		booking2.setTicketstatus("Confirmed");

		return booking2;
	}

	@Override
	public boolean isPnrNumberPresent(String pnrNumber) {
		// TODO Auto-generated method stub
		return bookingRepository.existsByPnr(pnrNumber);
	}

	@Override
	public Booking getPNRBookingData(String pnrNo) {
		// TODO Auto-generated method stub
		return bookingRepository.findByPnr(pnrNo);
	}

	@Override
	public List<Booking> getEmailBookingData(String email) {
		// TODO Auto-generated method stub
		return bookingRepository.findByEmail(email);
	}

	@Override
	public boolean isBookingEmailPresent(String email) {
		// TODO Auto-generated method stub
		return bookingRepository.existsByEmail(email);
	}

	@Override
	public Booking cancelFlightTicket(int bookingId) {
		// TODO Auto-generated method stub
		Booking booking = bookingRepository.getOne(bookingId);
		
		Booking booking2 = new Booking();
		booking2.setAirlineName(booking.getAirlineName());
		booking2.setFlightNumber(booking.getFlightNumber());
		booking2.setFastName(booking.getFastName());
		booking2.setLastName(booking.getLastName());
		booking2.setArrival(booking.getArrival());
		booking2.setDeparture(booking.getDeparture());
		booking2.setDepartureDate(booking.getDepartureDate());
		booking2.setArrivalDate(booking.getArrivalDate());
		booking2.setMobile(booking.getMobile());
		booking2.setEmail(booking.getEmail());
		booking2.setGender(booking.getGender());
		booking2.setPnr(booking.getPnr());
		booking2.setTicketstatus("Cancelled");
		
		bookingRepository.save(booking2);
		
		return booking2;
	}

}
