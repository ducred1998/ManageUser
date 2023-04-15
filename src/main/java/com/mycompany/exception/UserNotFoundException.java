package com.mycompany.exception;

public class UserNotFoundException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1386826581350819808L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
