package com.fedex.intellisense.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "INCIDENT")
public class Incident implements Serializable {
	
	private static final long serialVersionUID = -156767367637367367L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INCIDENT_ID")
	private Long incidentId;
	@Column(name = "EMP_NBR")
	private Long employeeNumber;
	@Column(name = "ROUTE_NUMBER")
	private Integer routeNumber;
	@Column(name = "ALPHA_CODE")
	private String alphaCode;
	@Column(name = "BUS_ID_NBR")
	private Long businessIdNumber;
	@Column(name = "REPORTING_DATE")
	private LocalDate reportedDate;
	@Column(name = "ISSUE_ID")
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
