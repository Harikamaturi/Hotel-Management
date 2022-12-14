package com.receptionist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="guest")
public class GuestDetails {
	
	@Id
	private int guestId;
	private String name;
	private long contact;
	private char gender;
	private String email;
	private String address;
	
	public GuestDetails() {
		super();
	}

	public GuestDetails(int guestId, String name, long contact, char gender, String email, String address) {
		super();
		this.guestId = guestId;
		this.name = name;
		this.contact = contact;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "GuestDetails [guestId=" + guestId + ", name=" + name + ", contact=" + contact + ", gender=" + gender
				+ ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
