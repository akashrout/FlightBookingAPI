package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.flight.service.BookingService;

@Service
public class BookingValidator {
	
	@Autowired
	private BookingService bookingService;
	
	public boolean isPNRPresent(String pnrNumber) {
		if (bookingService.isPnrNumberPresent(pnrNumber)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmailPresent(String email) {
		if (bookingService.isBookingEmailPresent(email)) {
			return true;
		} else {
			return false;
		}
	}

}
