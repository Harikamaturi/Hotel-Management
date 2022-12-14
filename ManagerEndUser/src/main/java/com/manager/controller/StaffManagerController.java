package com.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.exception.StaffNotFoundException;
import com.manager.fiegnclient.StaffFiegnClient;
import com.manager.model.Staff;


@RestController
@RequestMapping("/staff")

public class StaffManagerController {
	@Autowired
	private StaffFiegnClient staffClient;
	
	@PostMapping("/addStaffDetails")
	public ResponseEntity<Staff> addStaffDetails(@RequestBody Staff staffDetails) throws StaffNotFoundException {
		return staffClient.addStaffDetails(staffDetails);
	}
	@PutMapping("/updateStaffDetails")
	public ResponseEntity<Staff> updateStaffDetails(@RequestBody Staff staffDetails) throws StaffNotFoundException{
		return staffClient.updateStaffDetails(staffDetails);
	}
	@DeleteMapping("/deleteStaffDetails/{id}")
	public ResponseEntity<String> deleteStaffDetails(@PathVariable("id") int id) throws StaffNotFoundException{
		return staffClient.deleteStaffDetails(id);
	}
}
