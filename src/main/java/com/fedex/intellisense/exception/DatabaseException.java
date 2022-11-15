package com.fedex.intellisense.exception;

/**
 * This is a DatabaseException class which is a Custom User Exception of the Intellisense API.
 */
public class DatabaseException extends Exception {
	
	public DatabaseException(Long productId) {
        super("Database Exception : " + productId);
    }
	public DatabaseException(String status) {
        super("Database Exception : " + status);
    }

}
