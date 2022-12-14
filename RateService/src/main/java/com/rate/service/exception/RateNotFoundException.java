package com.rate.service.exception;

@SuppressWarnings("serial")
public class RateNotFoundException extends Exception{
	public RateNotFoundException() {
		super();
	}

	public RateNotFoundException(String message) {
		super(message);
	}

	public RateNotFoundException(Throwable cause) {
		super(cause);
	}

}
