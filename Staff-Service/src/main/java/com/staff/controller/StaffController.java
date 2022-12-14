package com.staff.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staff.exception.StaffNotFoundException;
import com.staff.model.Staff;
import com.staff.service.StaffServiceImpl;



@RestController
@RequestMapping("staff")
public class StaffController {
	
	@Autowired
	private StaffServiceImpl service;
	
	Logger log = LoggerFactory.getLogger(StaffController.class);
	
	@GetMapping("/all")
	public ResponseEntity<List<Staff>> showAllStaffDetails(){
             List<Staff> staff = service.showAllStaffDetails();
             if(staff.isEmpty()) {
     			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
     		}
     		log.debug("Staff are {}",staff);
     		return new ResponseEntity<>(staff, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Staff> showStaffDetailsById(@PathVariable("id") int id) throws StaffNotFoundException {
		Staff staff = service.showStaffById(id);
		if(staff!=null) {
			log.debug("Staff Details: {}",staff);
			return new ResponseEntity<>(staff, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addStaffDetails")
	public ResponseEntity<Staff> addStaffDetails(@RequestBody Staff staffDetails) throws StaffNotFoundException {
		Staff staff = service.addStaffDetails(staffDetails);
		if(staff!=null) {
			log.debug("staff Details: {}",staff);
			return new ResponseEntity<>(staff, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateStaffDetails")
	public ResponseEntity<Staff> updateStaffDetails(@RequestBody Staff staff) throws StaffNotFoundException {
		Staff s = service.updateStaffDetails(staff);
		if(s!=null) {
			log.debug("Staff Details: {}",staff);
			return new ResponseEntity<>(staff, HttpStatus.CREATED);}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteStaffDetails/{id}")
	public ResponseEntity<String> deleteStaffDetails(@PathVariable("id") int id) throws StaffNotFoundException {
		service.deleteStaffDetails(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

}
