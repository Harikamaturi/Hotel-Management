package com.guestservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.model.GuestDetails;
import com.guestservice.repository.GuestDetailsRepository;

@Service
public class GuestDetailsServiceImplementation implements GuestDetailsService{
	@Autowired
	private GuestDetailsRepository guestDetailsRepository;
	
	Logger log = LoggerFactory.getLogger(GuestDetailsServiceImplementation.class);
	
	@Override
	public List<GuestDetails> showAllGuestDetails() {
		log.info("Show All Guest Details Method Started");
		List<GuestDetails> guestDetails = guestDetailsRepository.findAll();
		log.debug("Guest Details are {} ", guestDetails);
		log.info("Show All Guest Details Method Ended");
		return guestDetails;
	}

	@Override
	public GuestDetails showGuestById(int id) throws GuestNotFoundException {
		log.info("Show Guest By Id Method Started");
		return guestDetailsRepository.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest with the id " + id + " Doesn't Exists"));
		
	}

	@Override
	public GuestDetails addGuestDetails(GuestDetails guestDetails) throws GuestNotFoundException{
		log.info("Add GuestDetails Method Started");
		Optional<GuestDetails> gd = guestDetailsRepository.findById(guestDetails.getGuestId());
		if (!gd.isPresent()) {
			log.info("Add CropDetails Method Ended");
			return guestDetailsRepository.insert(guestDetails);
		} else {
			return gd.orElseThrow(() -> new GuestNotFoundException("Guest Already Exists"));
		}
	}

	@Override
	public GuestDetails updateGuestDetails(GuestDetails guestDetails)throws GuestNotFoundException {
		log.info("Update Guest Method Started");
		Optional<GuestDetails> guest = guestDetailsRepository.findById(guestDetails.getGuestId());
		if (!guest.isPresent())
			return guest.orElseThrow(
					() -> new GuestNotFoundException("Guest with the id " + guestDetails.getGuestId() + " Doesn't Exists"));
		log.info("Update Guest Method Ended");
		return guestDetailsRepository.save(guestDetails);
	}

	@Override
	public String deleteGuestDetails(int id) throws GuestNotFoundException {
		log.info("Delete Guest Details Method Started");
		Optional<GuestDetails> guestDetails = guestDetailsRepository.findById(id);
		if (!guestDetails.isPresent()) {
			guestDetails.orElseThrow(() -> new GuestNotFoundException("Guest with the id " + id + " Doesn't Exists"));
		} else {
			guestDetailsRepository.deleteById(id);
			log.debug("Deleted SuccessFully {}", guestDetails);
			log.info("Delete Guest Method Ended");
		}
		return "Guest with the " + id + " Deleted Successfully!";
	}

}
