package com.manager.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manager.exception.StaffNotFoundException;
import com.manager.model.Staff;



@FeignClient(name="Staff-Service" , url="http://localhost:1003/staff")
public interface StaffFiegnClient {

	@PostMapping("/addStaffDetails")
	public ResponseEntity<Staff> addStaffDetails(@RequestBody Staff staffDetails) throws StaffNotFoundException;
		
	
	@PutMapping("/updateStaffDetails")
	public ResponseEntity<Staff> updateStaffDetails(@RequestBody Staff staff) throws StaffNotFoundException;
	
	@DeleteMapping("/deleteStaffDetails/{id}")
	public ResponseEntity<String> deleteStaffDetails(@PathVariable("id") int id) throws StaffNotFoundException;
	
}
