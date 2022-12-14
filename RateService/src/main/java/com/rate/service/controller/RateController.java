package com.rate.service.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rate.service.exception.RateNotFoundException;
import com.rate.service.jwt.filters.JwtUtil;
import com.rate.service.model.RateDetails;
import com.rate.service.models.AuthenticationRequest;
import com.rate.service.models.AuthenticationResponse;
import com.rate.service.models.User1;
import com.rate.service.repository.UserRepo;
import com.rate.service.service.MyUserDetailsService;
import com.rate.service.service.RateServiceImplementation;

@RestController
@RequestMapping("/rate")
public class RateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private UserRepo repo;
	@Autowired
	private RateServiceImplementation service;
	Logger log = LoggerFactory.getLogger(RateController.class);

	
	@GetMapping("/all")
	public ResponseEntity<List<RateDetails>> showAllRateDetails(){
             List<RateDetails> rateDetails = service.showAllRateDetails();
             if(rateDetails.isEmpty()) {
     			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
     		}
     		log.debug("Rate are {}",rateDetails);
     		return new ResponseEntity<>(rateDetails, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<RateDetails> showRateDetailsById(@PathVariable("id") int id) throws RateNotFoundException {
		RateDetails rateDetails = service.showRateById(id);
		if(rateDetails!=null) {
			log.debug("Rate Details: {}",rateDetails);
			return new ResponseEntity<>(rateDetails, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PostMapping("/add")
	public ResponseEntity<RateDetails> addRateDetails(@RequestBody RateDetails rateDetails) throws RateNotFoundException {
		RateDetails rate = service.addRateDetails(rateDetails);
		if(rate!=null) {
			log.debug("Rate Details: {}",rate);
			return new ResponseEntity<>(rate, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update")
	public ResponseEntity<RateDetails> updateRateDetails(@RequestBody RateDetails rateDetails) throws RateNotFoundException {
		RateDetails rate = service.updateRateDetails(rateDetails);
		if(rate!=null) {
			log.debug("Rate Details: {}",rate);
			return new ResponseEntity<>(rate, HttpStatus.CREATED);}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRateDetails(@PathVariable("id") int id) throws RateNotFoundException {
		service.deleteRateDetails(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}
	@PostMapping("/reg")
	private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
	{
        System.out.println("harika");
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
