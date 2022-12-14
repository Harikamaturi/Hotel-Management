package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.exception.InventoryNotFoundException;
import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepository;
@Service
public class InventoryServiceImplementation implements InventoryService {
	
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	Logger log = LoggerFactory.getLogger(InventoryServiceImplementation.class);

	@Override
	public List<Inventory> showAllInventoryDetails() {
		log.info("Show All Inventory Details Method Started");
		List<Inventory> inventoryDetails = inventoryRepository.findAll();
		log.debug("inventory are {} ", inventoryDetails);
		log.info("Show All Inventory Details Method Ended");
		return inventoryDetails;
	}

	@Override
	public Inventory showInventoryById(int id) throws InventoryNotFoundException {
		log.info("Show Inventory By Id Method Started");
		return inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFoundException("Inventory with the id " + id + " Doesn't Exists"));
		
	}
		

	@Override
	public Inventory addInventoryDetails(Inventory inventory) throws InventoryNotFoundException {
		log.info("Add Inventory Method Started");
		Optional<Inventory> inventoryDetails = inventoryRepository.findById(inventory.getInventoryCode());
		if (!inventoryDetails.isPresent()) {
			log.info("Add Inventory Method Ended");
			return inventoryRepository.insert(inventory);
		} else {
			return inventoryDetails.orElseThrow(() -> new InventoryNotFoundException("Inventory Already Exists"));
		}
	}
	@Override
	public Inventory updateInventoryDetails(Inventory inventory) throws InventoryNotFoundException {
		log.info("Update Inventory Method Started");
		Optional<Inventory> inventoryDetails = inventoryRepository.findById(inventory.getInventoryCode());
		if (!inventoryDetails.isPresent())
			return inventoryDetails.orElseThrow(
					() -> new InventoryNotFoundException("Inventory with the id " + inventory.getInventoryCode() + " Doesn't Exists"));
		log.info("Update Inventory Method Ended");
		return inventoryRepository.save(inventory);	
	}
	@Override
	public String deleteInventoryDetails(int id) throws InventoryNotFoundException {
		log.info("Delete Inventory Method Started");
		Optional<Inventory> inventoryDetails = inventoryRepository.findById(id);
		if (!inventoryDetails.isPresent()) {
			inventoryDetails.orElseThrow(() -> new InventoryNotFoundException("Inventory with the id " + id + " Doesn't Exists"));
		} else {
			inventoryRepository.deleteById(id);
			log.debug("Deleted SuccessFully {}", inventoryDetails);
			log.info("Delete Inventory Method Ended");
		}
		return "Inventory with the " + id + " Deleted Successfully!";
	}

		}
		
	
	