package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, Long>{
	
	public boolean existsByFlightNumber(String flightNumber); //flightNumber
	
	public List<FlightEntity> findByFlightNumber(String flightNumber);
	
	@Transactional
	@Modifying
	@Query("delete from FlightEntity f where f.flightNumber =?1")
	public void deleteFlightEntityByFlightNumber(String flightNumber);

	
}
