package com.app.bikestore.exception.handlers;

public class ResourceAlreadyExistsException extends RuntimeException {
	ResourceAlreadyExistsException() {
		this("Resource Already Exists");
	}
	
	ResourceAlreadyExistsException(String message) {
		this(message, null);
	}
	
	ResourceAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
