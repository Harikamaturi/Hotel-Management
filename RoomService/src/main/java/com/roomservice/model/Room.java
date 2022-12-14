package com.roomservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="rooms")
public class Room {
	
	@Id
	private String roomNumber;
	private boolean roomStatus;
	private Long totalRooms;
	
	public Room() {
		super();
	}

	public Room(String roomNumber, boolean roomStatus, Long totalRooms) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.totalRooms = totalRooms;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(boolean roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Long getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Long totalRooms) {
		this.totalRooms = totalRooms;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomStatus=" + roomStatus + ", totalRooms=" + totalRooms + "]";
	}

}
