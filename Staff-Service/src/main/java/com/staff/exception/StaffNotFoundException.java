package com.staff.exception;


@SuppressWarnings("serial")
public class StaffNotFoundException extends Exception {

	public StaffNotFoundException() {
		super();
	}

	public StaffNotFoundException(String message) {
		super(message);
	}

	public StaffNotFoundException(Throwable cause) {
		super(cause);
	}

}
