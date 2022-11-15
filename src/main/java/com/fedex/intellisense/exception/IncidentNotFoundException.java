package com.fedex.intellisense.exception;

/**
 * This is a IncidentNotFoundException class which is a Custom User Exception of the Intellisense API.
 */
public class IncidentNotFoundException extends Exception {
	
	public IncidentNotFoundException(Long productId) {
        super("Incident Not Found Exception : " + productId);
    }
	public IncidentNotFoundException(String status) {
        super("Incident Not Found Exception : " + status);
    }

}
