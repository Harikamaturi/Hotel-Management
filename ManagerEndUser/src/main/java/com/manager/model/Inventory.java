package com.manager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventorydetails")
public class Inventory {

	@Id
	private int inventoryCode;
	private String inventoryType;
	private String inventoryName;
	private int inventoryQuantity;

	public Inventory() {
		super();

	}

	public Inventory(int inventoryCode, String inventoryType, String inventoryName, int inventoryQuantity) {
		super();
		this.inventoryCode = inventoryCode;
		this.inventoryType = inventoryType;
		this.inventoryName = inventoryName;
		this.inventoryQuantity = inventoryQuantity;
	}

	public int getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

}
