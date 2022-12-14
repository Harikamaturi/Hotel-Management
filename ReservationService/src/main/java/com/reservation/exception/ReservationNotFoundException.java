package com.reservation.exception;

@SuppressWarnings("serial")
public class ReservationNotFoundException extends Exception {

	public ReservationNotFoundException() {
		super();
	}

	public ReservationNotFoundException(String message) {
		super(message);
	}

	public ReservationNotFoundException(Throwable cause) {
		super(cause);
	}

}
