package com.fedex.intellisense.model;

import java.time.LocalDate;

public class IncidentVO {
	
	private Long incidentId;
	private Long employeeNumber;
	private Integer routeNumber;
	private String alphaCode;
	private Long businessIdNumber;
	private LocalDate reportedDate;
	private Long issueId;
	public Long getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(Long incidentId) {
		this.incidentId = incidentId;
	}
	
	public Long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Integer getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(Integer routeNumber) {
		this.routeNumber = routeNumber;
	}
	public LocalDate getReportedDate() {
		return reportedDate;
	}
	public void setReportedDate(LocalDate reportedDate) {
		this.reportedDate = reportedDate;
	}
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public String getAlphaCode() {
		return alphaCode;
	}
	public void setAlphaCode(String alphaCode) {
		this.alphaCode = alphaCode;
	}
	public Long getBusinessIdNumber() {
		return businessIdNumber;
	}
	public void setBusinessIdNumber(Long businessIdNumber) {
		this.businessIdNumber = businessIdNumber;
	}
	
	
	
}
