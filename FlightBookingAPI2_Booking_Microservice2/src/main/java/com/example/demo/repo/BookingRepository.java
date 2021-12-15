package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.FlightEntity;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	public boolean existsByPnr(String pnrNumber);

	public Booking findByPnr(String pnrNumber);

	public boolean existsByEmail(String email);

	public List<Booking> findByEmail(String email);

}
