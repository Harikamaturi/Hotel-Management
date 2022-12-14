package com.owner.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reservation")
public class Reservation {
	@Id
	private int reservationCode;
	private int numberOfAdult;
	private int numberOfChildren;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int numberOfNights;
	private String name;
	private String emailId;
	private String phoneNumber;
	private String gender;
	private String address;
	private boolean status;

	public Reservation() {
		super();
	}

	public Reservation(int reservationCode, int numberOfAdult, int numberOfChildren, String checkIn,
			String checkOut, int numberOfNights, String name, String emailId, String phoneNumber, String gender,
			String address, boolean status) {
		super();
		this.reservationCode = reservationCode;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChildren = numberOfChildren;
		this.checkIn = LocalDate.parse(checkIn);
		this.checkOut = LocalDate.parse(checkOut);
		this.numberOfNights = numberOfNights;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.status = status;
	}

	public int getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(int reservationCode) {
		this.reservationCode = reservationCode;
	}

	public int getNumberOfAdult() {
		return numberOfAdult;
	}

	public void setNumberOfAdult(int numberOfAdult) {
		this.numberOfAdult = numberOfAdult;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = LocalDate.parse(checkIn);
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = LocalDate.parse(checkOut);
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation [reservationCode=" + reservationCode + ", numberOfAdult=" + numberOfAdult
				+ ", numberOfChildren=" + numberOfChildren + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", numberOfNights=" + numberOfNights + ", name=" + name + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", gender=" + gender + ", address=" + address + ", status ="
				+ status + "]";
	}

}
