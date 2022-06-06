package com.app.bikestore.exception.handlers;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		this("Resource Not Found");
	}
	
	public ResourceNotFoundException(String message) {
		this(message, null);
	}
	
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
