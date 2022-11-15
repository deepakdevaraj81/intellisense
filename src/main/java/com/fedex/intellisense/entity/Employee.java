package com.fedex.intellisense.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -156767367637367367L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_NBR")
	private Long employeeNumber;
	@Column(name = "EMP_NAME")
	private String employeeName;
	@Column(name = "EMP_PWD")
	private String employeePassword;
	@Column(name = "EMP_EMAIL_ID")
	private String employeeEmailId;
	@Column(name = "EMP_MGR_NBR")
	private Long managerNumber;
	@Column(name = "ALPHA_CODE")
	private String alphaCode;
	@Column(name = "BUS_ID_NBR")
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
