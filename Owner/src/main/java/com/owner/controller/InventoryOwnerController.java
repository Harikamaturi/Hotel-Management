package com.owner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.owner.exception.InventoryNotFoundException;
import com.owner.feignclient.InventoryFeignClient;
import com.owner.model.Inventory;

@RestController
@RequestMapping("owner/inventory")
public class InventoryOwnerController {
	@Autowired
	private InventoryFeignClient inventoryClient;

	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> showAllInventory(@RequestHeader("Authorization") String token) {
		return inventoryClient.showAllInventory(token);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Inventory> showInventoryById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws InventoryNotFoundException {
		return inventoryClient.showById(id, token);
	}

	@PostMapping("/addinventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token)
			throws InventoryNotFoundException {

		return inventoryClient.addInventory(inventoryDetails, token);
	}

	@PutMapping("/updateinventory")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryDetails,@RequestHeader("Authorization") String token)
			throws InventoryNotFoundException {

		return inventoryClient.updateInventory(inventoryDetails, token);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteInventory(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws InventoryNotFoundException {

		return inventoryClient.deleteInventory(id, token);
	}

}
