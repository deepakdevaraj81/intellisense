package com.fedex.intellisense.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fedex.intellisense.entity.Incident;
import com.fedex.intellisense.entity.Issue;
import com.fedex.intellisense.entity.Vehicle;
import com.fedex.intellisense.entity.Employee;
import com.fedex.intellisense.model.IncidentVO;
import com.fedex.intellisense.model.IssueVO;
import com.fedex.intellisense.model.VehicleVO;
import com.fedex.intellisense.model.EmployeeVO;
import com.fedex.intellisense.repository.IssueRepository;
import com.fedex.intellisense.service.IntellisenseService;

@Component
public class IntellisenseAdapter {
	
	Logger log = LogManager.getLogger(IntellisenseAdapter.class);
	
	@Autowired
	IssueRepository issueRepository;
		
	public List<IncidentVO> convertIncidentListToIncidentVOList(List<Incident> incidentList) {
		log.info("IntellisenseAdapter::convertIncidentListToIncidentVOList()");
		List<IncidentVO> incidentVOList = new ArrayList<IncidentVO>();
		if(!CollectionUtils.isEmpty(incidentList)) {
			for(Incident incident:incidentList) {
				IncidentVO incidentVO = new IncidentVO();
				incidentVO.setIncidentId(incident.getIncidentId());
				incidentVO.setEmployeeNumber(incident.getEmployeeNumber());
				incidentVO.setRouteNumber(incident.getRouteNumber());
				incidentVO.setReportedDate(incident.getReportedDate());
				incidentVO.setIssueId(incident.getIssueId());
				incidentVOList.add(incidentVO);
			}
		}	
		return incidentVOList;
	}
	public IssueVO convertIssueEntityToIssueVO(Issue issue) {
		log.info("IntellisenseAdapter::convertIssueEntityToIssueVO()");
		IssueVO issueVO = new IssueVO();
		issueVO.setIssueId(issue.getIssueId());
		issueVO.setIssueName(issue.getIssueName());
		issueVO.setIssueDescription(issue.getIssueDescription());
		return issueVO;
	}
	
	public EmployeeVO convertEmployeeEntityToEmployeeVO(Employee employee) {
		log.info("IntellisenseAdapter::convertEmployeeEntityToEmployeeVO()");
		if(employee != null) {
			log.info("IntellisenseAdapter::convertEmployeeEntityToEmployeeVO()::employee::"+employee);
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmployeeNumber(employee.getEmployeeNumber());
			employeeVO.setEmployeeName(employee.getEmployeeName());
			employeeVO.setEmployeePassword(employee.getEmployeePassword());
			employeeVO.setEmployeeEmailId(employee.getEmployeeEmailId());
			employeeVO.setManagerNumber(employee.getManagerNumber());
			employeeVO.setAlphaCode(employee.getAlphaCode());
			employeeVO.setBusinessIdNumber(employee.getBusinessIdNumber());
			return employeeVO;
		} else {
			log.info("IntellisenseAdapter::convertEmployeeEntityToEmployeeVO()::employee:"+employee);
			return null;
		}
	}
	
	public Incident convertIncidentVOModelToEntity(IncidentVO inc) {
		log.info("IntellisenseAdapter::convertIncidentVOModelToEntity()");
		Incident incident = new Incident();
		if(inc!=null) {
			Optional<Issue> issueOps = issueRepository.findById(inc.getIssueId());
			incident.setRouteNumber(inc.getRouteNumber());
			incident.setReportedDate(inc.getReportedDate());
			incident.setIssueId(issueOps.get().getIssueId());
		}	
		return incident;
	}
	
	public Issue convertIssueVOModelToEntity(IssueVO issueVO) {
		log.info("IntellisenseAdapter::convertIssueVOModelToEntity()");
		Issue issue = null;
		if(issueVO!=null) {
			issue = new Issue();
			issue.setIssueName(issueVO.getIssueName());
			issue.setIssueDescription(issueVO.getIssueDescription());
		}
		return issue;
	}
	
	public Vehicle convertVehicleVOModelToEntity(VehicleVO vehicleVO) {
		log.info("IntellisenseAdapter::convertVehicleVOModelToEntity()");
		Vehicle vehicle = null;
		if(vehicleVO!=null) {
			vehicle = new Vehicle();
			vehicle.setVehicleNumber(vehicleVO.getVehicleNumber());
			vehicle.setOdometerType(vehicleVO.getOdometerType());
		}
		return vehicle;
	}
	
	public Employee convertEmployeeVOModelToEntity(EmployeeVO employeeVO) {
		log.info("IntellisenseAdapter::convertIssueVOModelToEntity()");
		Employee employee = null;
		if(employeeVO!=null) {
			employee = new Employee();
			employee.setEmployeeName(employeeVO.getEmployeeName());
			employee.setEmployeePassword(employeeVO.getEmployeePassword());
			employee.setEmployeeEmailId(employeeVO.getEmployeeEmailId());
			employee.setManagerNumber(employeeVO.getManagerNumber());
			employee.setAlphaCode(employeeVO.getAlphaCode());
			employee.setBusinessIdNumber(employeeVO.getBusinessIdNumber());
		}
		return employee;
	}
	
	public List<IssueVO> convertIssueListToIssueVOList(List<Issue> issueList) {
		log.info("IntellisenseAdapter::convertIssueListToIssueVOList()");
		List<IssueVO> issueVOList = new ArrayList<IssueVO>();
		if(!CollectionUtils.isEmpty(issueList)) {
			for(Issue issue:issueList) {
				IssueVO issueVO = new IssueVO();
				issueVO.setIssueId(issue.getIssueId());
				issueVO.setIssueName(issue.getIssueName());
				issueVO.setIssueDescription(issue.getIssueDescription());
				issueVOList.add(issueVO);
			}
		}	
		return issueVOList;
	}
	public List<VehicleVO> convertVehicleListToVehicleVOList(List<Vehicle> vehicleList) {
		log.info("IntellisenseAdapter::convertIssueListToIssueVOList()");
		List<VehicleVO> vehicleVOList = new ArrayList<VehicleVO>();
		if(!CollectionUtils.isEmpty(vehicleList)) {
			for(Vehicle vehicle:vehicleList) {
				VehicleVO vehicleVO = new VehicleVO();
				vehicleVO.setVehicleId(vehicle.getVehicleId());
				vehicleVO.setVehicleNumber(vehicle.getVehicleNumber());
				vehicleVO.setOdometerType(vehicle.getOdometerType());
				vehicleVOList.add(vehicleVO);
			}
		}	
		return vehicleVOList;
	}
	

}
