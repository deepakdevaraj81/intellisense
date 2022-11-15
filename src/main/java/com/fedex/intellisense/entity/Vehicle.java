package com.fedex.intellisense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
	
	private static final long serialVersionUID = -156767367637367367L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private Long vehicleId;
	@Column(name = "VEHICLE_NBR")
	private Long vehicleNumber;
	@Column(name = "ODOMETER_TYPE")
	private String odometerType;
	
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Long getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(Long vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getOdometerType() {
		return odometerType;
	}
	public void setOdometerType(String odometerType) {
		this.odometerType = odometerType;
	}
	
	
	
	
	

}
