package com.fedex.intellisense.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.intellisense.entity.Issue;
import com.fedex.intellisense.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle , Long> {

	
	Logger log = LogManager.getLogger(VehicleRepository.class);
	
	@Query(value = "SELECT VEHICLE_ID, VEHICLE_NBR, ODOMETER_TYPE FROM VEHICLE", nativeQuery = true)
	public List<Vehicle> getVehicle();
	
	public Vehicle save( Vehicle vehicle);
	
	
}
