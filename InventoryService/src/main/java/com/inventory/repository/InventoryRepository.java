package com.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Inventory;


@Repository
public interface InventoryRepository extends MongoRepository<Inventory, Integer> {

}
