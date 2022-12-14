package com.receptionist.feignclient;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.receptionist.exception.GuestNotFoundException;
import com.receptionist.model.GuestDetails;

@FeignClient(name="guest-service", url="http://localhost:9002/guest")
public interface GuestFeignClient {
	
	@GetMapping("/all")
	public ResponseEntity<List<GuestDetails>> showAllGuest();
	
	@GetMapping("/{id}")
	public ResponseEntity<GuestDetails> showById(@PathVariable("id")int id)throws GuestNotFoundException;
	
	@PostMapping("/addguest")
	public ResponseEntity<GuestDetails> addGuest(@RequestBody GuestDetails guestDetails) throws GuestNotFoundException;

	@PutMapping("/updateguest")
	public ResponseEntity<GuestDetails> updateGuest(@RequestBody GuestDetails guestDetails) throws GuestNotFoundException;
	
	@DeleteMapping("/deleteguest/{id}")
	public ResponseEntity<String> deleteGuest(@PathVariable("id") int id) throws GuestNotFoundException;

}
