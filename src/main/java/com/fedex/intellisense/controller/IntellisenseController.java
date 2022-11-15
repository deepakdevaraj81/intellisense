package com.fedex.intellisense.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.intellisense.exception.DatabaseException;
import com.fedex.intellisense.exception.IncidentNotFoundException;
import com.fedex.intellisense.exception.IssueNotFoundException;
import com.fedex.intellisense.model.EmployeeVO;
import com.fedex.intellisense.model.IncidentVO;
import com.fedex.intellisense.model.IssueVO;
import com.fedex.intellisense.service.IntellisenseService;


@RestController
@RequestMapping(value="/intellisense")
public class IntellisenseController {
	
	@Autowired
	IntellisenseService intellisenseService;

	Logger log = LogManager.getLogger(IntellisenseController.class);
	
	@RequestMapping(value="/login/{userName}/{userPassword}" , method = RequestMethod.GET)
    public EmployeeVO login(@PathVariable("userName") String userName , @PathVariable("userPassword") String userPassword) throws Exception , DatabaseException {
        
        log.info("IntellisenseController::login()");
        return intellisenseService.login(userName , userPassword);
    }
	
	@RequestMapping(value="/{routeNumber}", method = RequestMethod.GET)
    public List<IncidentVO> getIncidentsByRouteNumber(@PathVariable("routeNumber") Integer routeNumber) throws DatabaseException , IncidentNotFoundException {
        
        log.info("IntellisenseController::getIncidentsByRouteNumber()");
        return intellisenseService.getIncidentsByRouteNumber(routeNumber);
    }
	
	@RequestMapping( value="/addIncident", method = RequestMethod.POST)
    public ResponseEntity<String> addIncident(@RequestBody IncidentVO incident) throws DatabaseException {
        
        log.info("IntellisenseController::addIncident()");
        return new ResponseEntity<>(intellisenseService.addIncident(incident) , HttpStatus.CREATED);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public List<IssueVO> getIssues() throws IssueNotFoundException , DatabaseException {
        
        log.info("IntellisenseController::getIssues()");
        return intellisenseService.getIssues();
    }
	
	@RequestMapping( value="/addIssue", method = RequestMethod.POST)
    public ResponseEntity<String> addIssue(@RequestBody IssueVO issue) throws DatabaseException {
        
        log.info("IntellisenseController::addIncident()");
        return new ResponseEntity<>(intellisenseService.addIssue(issue) , HttpStatus.CREATED);
    }
	
	@RequestMapping( value="/addEmployee", method = RequestMethod.POST)
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeVO employeeVO) throws DatabaseException {
        
        log.info("IntellisenseController::addEmployee()");
        return new ResponseEntity<>(intellisenseService.addEmployee(employeeVO) , HttpStatus.CREATED);
    }
}
