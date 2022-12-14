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

import com.receptionist.exception.ReservationNotFoundException;
import com.receptionist.feignclient.ReservationFeignClient;
import com.receptionist.model.Reservation;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationFeignClient reservationClient;
	
	@GetMapping("/all")
	public ResponseEntity<List<Reservation>> showAllReservation(){
     		return reservationClient.showAllReservation();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> showReservationById(@PathVariable("id") int id) throws ReservationNotFoundException {
			return reservationClient.showById(id);
	}
	
	@PostMapping("/addreservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) throws ReservationNotFoundException {
		return reservationClient.addReservation(reservation);
	}
	@PutMapping("/updatereservation")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) throws ReservationNotFoundException{
		return reservationClient.updateReservation(reservation);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable("id") int id) throws ReservationNotFoundException{
		return reservationClient.deleteReservation(id);
	}
}
