package com.capg.pbms.Exception;

public class InsufficientBalanceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
	
	}
	
	public InsufficientBalanceException(String message) {
		super(message);
	}

}
