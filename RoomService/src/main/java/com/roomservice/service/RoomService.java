package com.roomservice.service;

import java.util.List;

import com.roomservice.exception.RoomNotFoundException;
import com.roomservice.model.Room;

public interface RoomService {
	public List<Room> showAllRoom()throws RoomNotFoundException;
	public Room showRoomById(String id) throws RoomNotFoundException;
	public Room addRoom(Room room) throws RoomNotFoundException;
	public Room updateRoom(Room room)throws RoomNotFoundException;
	public String deleteRoom(String id) throws RoomNotFoundException;
}