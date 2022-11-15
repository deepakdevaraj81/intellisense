package com.fedex.intellisense.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.intellisense.entity.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident , Long> {

	
	Logger log = LogManager.getLogger(IncidentRepository.class);
	
	@Query(value = "SELECT INCIDENT_ID, EMP_NBR , ROUTE_NUMBER, REPORTING_DATE, ISSUE_ID FROM INCIDENT WHERE ROUTE_NUMBER = ?", nativeQuery = true)
	public List<Incident> getIncidentsByRouteNumber(Integer routeNumber);
	
	public Incident save(Incident incident);
	
	
}
