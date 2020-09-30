package com.capg.pbms.Exception;

public class InvalidAccountNumberException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidAccountNumberException()  {

	}
	
	public InvalidAccountNumberException(String message) {
		super(message);
	}

}
