package com.manager.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private HttpStatus statusMessage;
	private String msg;
	private LocalDateTime dateTime;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(HttpStatus statusMessage, String msg, LocalDateTime dateTime) {
		super();
		this.statusMessage = statusMessage;
		this.msg = msg;
		this.dateTime = dateTime;
	}

	public HttpStatus getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(HttpStatus statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
