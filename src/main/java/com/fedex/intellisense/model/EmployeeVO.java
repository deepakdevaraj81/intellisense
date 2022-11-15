package com.fedex.intellisense.model;

import javax.persistence.Column;

public class EmployeeVO {

	private Long employeeNumber;
	private String employeeName;
	private String employeePassword;
	private String employeeEmailId;
	private Long managerNumber;
	private String alphaCode;
	private Long businessIdNumber;
	
	public Long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeEmailId() {
		return employeeEmailId;
	}
	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}
	public Long getManagerNumber() {
		return managerNumber;
	}
	public void setManagerNumber(Long managerNumber) {
		this.managerNumber = managerNumber;
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
