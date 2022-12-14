package com.guestservice.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.jwt.jwtutil.JwtUtil;
import com.guestservice.jwt.jwtutil.User1;
import com.guestservice.jwt.models.AuthenticationRequest;
import com.guestservice.jwt.models.AuthenticationResponse;
import com.guestservice.jwt.service.MyUserDetailsService;
import com.guestservice.jwt.service.UserRepo;
import com.guestservice.model.GuestDetails;
import com.guestservice.service.GuestDetailsServiceImplementation;

@RestController
@RequestMapping("/guest")
public class GuestDetailsController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private UserRepo repo;
	@Autowired
	private GuestDetailsServiceImplementation service;
	
	Logger log = LoggerFactory.getLogger(GuestDetailsController.class);
	
	@GetMapping("/all")
	public ResponseEntity<List<GuestDetails>> showAllGuestDetails(){
             List<GuestDetails> guestDetails = service.showAllGuestDetails();
             if(guestDetails.isEmpty()) {
     			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
     		}
     		log.debug("Guest are {}",guestDetails);
     		return new ResponseEntity<>(guestDetails, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GuestDetails> showGuestDetailsById(@PathVariable("id") int id) throws GuestNotFoundException {
		GuestDetails guestDetails = service.showGuestById(id);
		if(guestDetails!=null) {
			log.debug("Guest Details: {}",guestDetails);
			return new ResponseEntity<>(guestDetails, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addguest")
	public ResponseEntity<GuestDetails> addGuestDetails(@RequestBody GuestDetails guestDetails) throws GuestNotFoundException {
		GuestDetails guest = service.addGuestDetails(guestDetails);
		if(guest!=null) {
			log.debug("Guest Details: {}",guest);
			return new ResponseEntity<>(guest, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateguest")
	public ResponseEntity<GuestDetails> updateCroDetails(@RequestBody GuestDetails guestDetails) throws GuestNotFoundException {
		GuestDetails guest = service.updateGuestDetails(guestDetails);
		if(guest!=null) {
			log.debug("Guest Details: {}",guest);
			return new ResponseEntity<>(guest, HttpStatus.CREATED);}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteguest/{id}")
	public ResponseEntity<String> deleteGuestDetails(@PathVariable("id") int id) throws GuestNotFoundException {
		service.deleteGuestDetails(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}
	@PostMapping("/reg")
	private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
	{
     
		String username = request.getUsername();
		String password = request.getPassword();

		User1 model = new User1();
		model.setUsername(username);
		model.setPassword(password);

		try {
			repo.save(model);
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
		}
		    return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try
		{
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}


}
