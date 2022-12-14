package com.manager.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manager.exception.InventoryNotFoundException;

import com.manager.model.Inventory;


@FeignClient(name="inventory-details-service" , url="http://localhost:1000/inventory")
public interface InventoryFeignClient {

			@PostMapping("/addInventoryDetails")
			public ResponseEntity<Inventory> addInventoryDetails(@RequestBody Inventory inventoryDetails) throws InventoryNotFoundException;

			@PutMapping("/updateInventoryDetails")
			public ResponseEntity<Inventory> updateInventoryDetails(@RequestBody Inventory inventoryDetails) throws InventoryNotFoundException;
			
			@DeleteMapping("/deleteInventoryDetails/{id}")
			public ResponseEntity<String> deleteInventoryDetails(@PathVariable("id") int id) throws InventoryNotFoundException;
			
		}



