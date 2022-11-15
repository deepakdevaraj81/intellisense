package com.fedex.intellisense.exception;

/**
 * This is a IncidentNotFoundException class which is a Custom User Exception of the Intellisense API.
 */
public class IssueNotFoundException extends Exception {
	
	public IssueNotFoundException(Long productId) {
        super("Incident Not Found Exception : " + productId);
    }
	public IssueNotFoundException(String status) {
        super("Incident Not Found Exception : " + status);
    }

}
