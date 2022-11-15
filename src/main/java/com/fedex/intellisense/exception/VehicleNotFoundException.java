package com.fedex.intellisense.exception;

/**
 * This is a IncidentNotFoundException class which is a Custom User Exception of the Intellisense API.
 */
public class VehicleNotFoundException extends Exception {
	
	public VehicleNotFoundException(Long productId) {
        super("Vehicle Not Found Exception : " + productId);
    }
	public VehicleNotFoundException(String status) {
        super("Vehicle Not Found Exception : " + status);
    }

}
