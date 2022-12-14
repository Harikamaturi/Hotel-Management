package com.inventory.controller;

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

import com.inventory.exception.InventoryNotFoundException;
import com.inventory.model.Inventory;
import com.inventory.service.InventoryServiceImplementation;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryServiceImplementation service;
	

	Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> showAllinventoryDetails(){
             List<Inventory> inventory = service.showAllInventoryDetails();
             if(inventory.isEmpty()) {
     			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
     		}
     		log.debug("Inventory are {}",inventory);
     		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> showInventoryDetailsById(@PathVariable("id") int id) throws InventoryNotFoundException {
		Inventory inventoryDetails = service.showInventoryById(id);
		if(inventoryDetails!=null) {
			log.debug("Inventory Details: {}",inventoryDetails);
			return new ResponseEntity<>(inventoryDetails, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addInventoryDetails")
	public ResponseEntity<Inventory> addInventoryDetails(@RequestBody Inventory inventoryDetails) throws InventoryNotFoundException {
		Inventory inventory = service.addInventoryDetails(inventoryDetails);
		if(inventory!=null) {
			log.debug("Inventory Details: {}",inventory);
			return new ResponseEntity<>(inventory, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateInventoryDetails")
	public ResponseEntity<Inventory> updateInventoryDetails(@RequestBody Inventory inventoryDetails) throws InventoryNotFoundException {
		Inventory inventory = service.updateInventoryDetails(inventoryDetails);
		if(inventory!=null) {
			log.debug("Inventory Details: {}",inventory);
			return new ResponseEntity<>(inventory, HttpStatus.CREATED);}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteInventoryDetails/{id}")
	public ResponseEntity<String> deleteInventoryDetails(@PathVariable("id") int id) throws InventoryNotFoundException {
		service.deleteInventoryDetails(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

}

