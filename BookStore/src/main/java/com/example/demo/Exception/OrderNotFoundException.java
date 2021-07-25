package com.example.demo.Exception;

public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String message) {
		super(message);
	}

}
