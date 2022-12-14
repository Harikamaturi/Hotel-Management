package com.receptionist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="rooms")
public class Room {
	
	@Id
	private int roomNumber;
	private boolean roomStatus;
	private Long totalRooms;
	
	public Room() {
		super();
	}

	public Room(int roomNumber, boolean roomStatus, Long totalRooms) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.totalRooms = totalRooms;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
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
