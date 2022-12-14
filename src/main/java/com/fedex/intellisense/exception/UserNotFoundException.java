package com.fedex.intellisense.exception;

/**
 * This is a IncidentNotFoundException class which is a Custom User Exception of the Intellisense API.
 */
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(Long productId) {
        super("User Not Found Exception : " + productId);
    }
	public UserNotFoundException(String status) {
        super("User Not Found Exception : " + status);
    }

}
