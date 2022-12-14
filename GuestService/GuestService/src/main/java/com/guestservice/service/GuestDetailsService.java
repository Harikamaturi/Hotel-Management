package com.guestservice.service;

import java.util.List;

import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.model.GuestDetails;

public interface GuestDetailsService {
	public List<GuestDetails> showAllGuestDetails()throws GuestNotFoundException;
	public GuestDetails showGuestById(int id) throws GuestNotFoundException;
	public GuestDetails addGuestDetails(GuestDetails guestDetails) throws GuestNotFoundException;
	public GuestDetails updateGuestDetails(GuestDetails guestDetails)throws GuestNotFoundException;
	public String deleteGuestDetails(int id) throws GuestNotFoundException;
	
	

}
