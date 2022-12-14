package com.receptionist.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receptionist.exception.GuestNotFoundException;
import com.receptionist.feignclient.GuestFeignClient;
import com.receptionist.model.GuestDetails;

@RestController
@RequestMapping("/guest")
public class GuestDetailsController {
	
	@Autowired
	private GuestFeignClient guestFeignClient;
	
	@GetMapping("/all")
	public ResponseEntity<List<GuestDetails>> showAllGuest(){
     		return guestFeignClient.showAllGuest();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GuestDetails> showGuestById(@PathVariable("id") int id) throws GuestNotFoundException {
			return guestFeignClient.showById(id);
	}
	
	@PostMapping("/addguest")
	public ResponseEntity<GuestDetails> addGuest(@RequestBody GuestDetails guestDetails) throws GuestNotFoundException {
		return guestFeignClient.addGuest(guestDetails);
	}
	
	@PutMapping("/updateguest")
	public ResponseEntity<GuestDetails> updateGuest(@RequestBody GuestDetails guestDetails) throws GuestNotFoundException{
		return guestFeignClient.updateGuest(guestDetails);
	}
	
	@DeleteMapping("/deleteguest/{id}")
	public ResponseEntity<String> deleteGuest(@PathVariable("id") int id) throws GuestNotFoundException{
		return guestFeignClient.deleteGuest(id);
	}
}
