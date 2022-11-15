package com.fedex.intellisense.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fedex.intellisense.adapter.IntellisenseAdapter;
import com.fedex.intellisense.model.IssueVO;
import com.fedex.intellisense.model.VehicleVO;
import com.fedex.intellisense.entity.Employee;
import com.fedex.intellisense.entity.Incident;
import com.fedex.intellisense.entity.Issue;
import com.fedex.intellisense.entity.Vehicle;
import com.fedex.intellisense.exception.DatabaseException;
import com.fedex.intellisense.exception.IncidentNotFoundException;
import com.fedex.intellisense.exception.IssueNotFoundException;
import com.fedex.intellisense.exception.UserNotFoundException;
import com.fedex.intellisense.exception.VehicleNotFoundException;
import com.fedex.intellisense.model.EmployeeVO;
import com.fedex.intellisense.model.IncidentVO;
import com.fedex.intellisense.repository.IncidentRepository;
import com.fedex.intellisense.repository.IssueRepository;
import com.fedex.intellisense.repository.VehicleRepository;
import com.fedex.intellisense.repository.EmployeeRepository;

@Service
public class IntellisenseService {
	
	@Autowired
	IncidentRepository incidentRepository;
	
	@Autowired
	IssueRepository issueRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	IntellisenseAdapter intellisenseAdapter;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	Logger log = LogManager.getLogger(IntellisenseService.class);
	
	
	
	public List<IncidentVO> getIncidentsByRouteNumber(Integer routeNumber) throws DatabaseException , IncidentNotFoundException {
		log.info("IntellisenseService::getIncidentsByRouteNumber()");
		List<Incident> incidentList = null;
		List<IncidentVO> incidentVOList = null;
		try {
			incidentList = incidentRepository.getIncidentsByRouteNumber(routeNumber);
		} catch(Exception e) {
			throw new DatabaseException("Exception occurred during Get Incident");
		}	
		if(CollectionUtils.isEmpty(incidentList)) {
			throw new IncidentNotFoundException("No Incidents Found");
		} else {
			incidentVOList = intellisenseAdapter.convertIncidentListToIncidentVOList(incidentList);
		}	
		return incidentVOList;
	}
	
	public String addIncident(IncidentVO incidentVO) throws DatabaseException {
		log.info("IntellisenseService::addIncident()");
		Incident incident = intellisenseAdapter.convertIncidentVOModelToEntity(incidentVO);
		try {
			incidentRepository.save(incident);
			return "Incident Saved Successfully";
		} catch(Exception e) {
			throw new DatabaseException("Exception occurred during Save Incident");
		}
	}
	
	public List<IssueVO> getIssues() throws IssueNotFoundException , DatabaseException {
        
        log.info("IntellisenseService::getIssues()");
        List<Issue> issueList = null;
        try {
        	issueList = issueRepository.getIssues();
        } catch(Exception e) {
			throw new DatabaseException("Exception occurred during Get Issues");
		}		
        if(CollectionUtils.isEmpty(issueList)) {
			throw new IssueNotFoundException("No Issues Found");
		} 
        List<IssueVO> issueVOList = intellisenseAdapter.convertIssueListToIssueVOList(issueList);
        return issueVOList;
    }
	
	public String addIssue(IssueVO issueVO) throws DatabaseException {
        
        log.info("IntellisenseService::addIssue()");
        Issue issue = intellisenseAdapter.convertIssueVOModelToEntity(issueVO);
        try {
        	issueRepository.save(issue);
        	return "Issue Saved Successfully";
        } catch(Exception e) {
			throw new DatabaseException("Exception occurred during Save Issue");
		}	
    }
	
	public String addEmployee(EmployeeVO employeeVO) throws DatabaseException {
		 log.info("IntellisenseService::addEmployee()");
		 Employee employee = intellisenseAdapter.convertEmployeeVOModelToEntity(employeeVO);
	        try {
	        	employeeRepository.save(employee);
	        	return "Employee Saved Successfully";
	        } catch(Exception e) {
				throw new DatabaseException("Exception occurred during Save Employee");
			}	
	}
    
	public EmployeeVO login(String userName , String userPassword) throws DatabaseException , Exception {
    	 log.info("IntellisenseService::login()");
    	 EmployeeVO employeeVO = null;
    	 Employee employee = null;
    	 try {
    		 employee = employeeRepository.login(userName , userPassword);
    	 } catch(Exception e) {
  			throw new DatabaseException("Exception occurred during User Login");
  		 }		 
    	 if(employee!=null) {
    		 employeeVO = intellisenseAdapter.convertEmployeeEntityToEmployeeVO(employee);
    	 } else {
    		 throw new UserNotFoundException("User does not exist");
    	 }
         
    	 return employeeVO;
    }
	
	public List<VehicleVO> getVehicle() throws VehicleNotFoundException , DatabaseException {
	        
	     log.info("IntellisenseService::getVehicle()");
	     
	     List<Vehicle> vehicleList = null;
	     try {
	    	 vehicleList = vehicleRepository.getVehicle();
	     } catch(Exception e) {
			throw new DatabaseException("Exception occurred during Get Issues");
		 }		
	     if(CollectionUtils.isEmpty(vehicleList)) {
	    	 throw new VehicleNotFoundException("No Vehicle Found");
		 } 
	     List<VehicleVO> vehicleVOList = intellisenseAdapter.convertVehicleListToVehicleVOList(vehicleList);
	     return vehicleVOList;
	     
	}
		
    public String addVehicle( VehicleVO vehicleVO) throws DatabaseException {
	        
	     log.info("IntellisenseService::addVehicle()");
	 	
	     Vehicle vehicle = intellisenseAdapter.convertVehicleVOModelToEntity(vehicleVO);
	     try {
	    	 vehicleRepository.save(vehicle);
	       	return "Vehicle Saved Successfully";
	     } catch(Exception e) {
	        throw new DatabaseException("Exception occurred during Save Vehicle");
		 }	
	     
	     
    }
}


