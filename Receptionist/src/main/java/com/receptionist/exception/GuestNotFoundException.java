package com.receptionist.exception;

@SuppressWarnings("serial")

public class GuestNotFoundException extends Exception {
	public GuestNotFoundException() {
		super();
	}

	public GuestNotFoundException(String message) {
		super(message);
	}

	public GuestNotFoundException(Throwable cause) {
		super(cause);
	}

}
