package com.owner.exception;

@SuppressWarnings("serial")

public class RoomNotFoundException extends Exception {
	public RoomNotFoundException() {
		super();
	}

	public RoomNotFoundException(String message) {
		super(message);
	}

	public RoomNotFoundException(Throwable cause) {
		super(cause);
	}

}
