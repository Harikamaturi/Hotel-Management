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

import com.manager.exception.InventoryNotFoundException;

import com.manager.fiegnclient.InventoryFeignClient;

import com.manager.model.Inventory;


@RestController
@RequestMapping("/inventory")
public class InventoryManagerController {
	@Autowired
	private InventoryFeignClient inventoryClient;
	
	@PostMapping("/add")
	public ResponseEntity<Inventory> addInventoryDetails(@RequestBody Inventory inventoryDetails) throws InventoryNotFoundException {
		return inventoryClient.addInventoryDetails(inventoryDetails);
	}
	@PutMapping("/update")
	public ResponseEntity<Inventory> updateInventoryDetails(@RequestBody Inventory inventoryDetails) throws InventoryNotFoundException{
		return inventoryClient.updateInventoryDetails(inventoryDetails);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteInventoryDetails(@PathVariable("id") int id) throws InventoryNotFoundException{
		return inventoryClient.deleteInventoryDetails(id);
	}

}
