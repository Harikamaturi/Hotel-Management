package com.owner.feignclient;

import java.util.List;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.owner.exception.InventoryNotFoundException;
import com.owner.model.Inventory;


@FeignClient(name = "InventoryService", url = "http://localhost:9003/inventory")
public interface InventoryFeignClient {
	
	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> showAllInventory(@RequestHeader("Authorization") String token);
	
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> showById(@PathVariable("id")int id,@RequestHeader("Authorization") String token)throws InventoryNotFoundException;

	@PostMapping("/addinventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token)
			throws InventoryNotFoundException;

	@PutMapping("/updateinventory")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token)
			throws InventoryNotFoundException;

	@DeleteMapping("/deleteinventory/{id}")
	public ResponseEntity<String> deleteInventory(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws InventoryNotFoundException;

}


