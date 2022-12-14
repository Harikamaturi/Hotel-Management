package com.roomservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomservice.exception.RoomNotFoundException;
import com.roomservice.model.Room;
import com.roomservice.repository.RoomRepository;

@Service
public class RoomServiceImplementation implements RoomService{
	
	@Autowired
	private RoomRepository roomRepository;

	Logger log = LoggerFactory.getLogger(RoomServiceImplementation.class);
	
	@Override
	public List<Room> showAllRoom() {
		log.info("Show All Room Method Started");
		List<Room> room = roomRepository.findAll();
		log.debug("The Rooms are{}",room);
		log.info("Show All Room Method Ended");
		return room;
	}

	@Override
	public Room showRoomById(String id) throws RoomNotFoundException {
		log.info("Show Room By Id Method Started");
		return roomRepository.findById(id)
				.orElseThrow(()-> new RoomNotFoundException("Room with the id "+id+ "Doesn't Exists"));
	}

	@Override
	public Room addRoom(Room room) throws RoomNotFoundException{
		log.info("Add Room Method Started");
		Optional<Room> rm = roomRepository.findById(room.getRoomNumber());
		if (!rm.isPresent()) {
			log.info("Add Room Method Ended");
			return roomRepository.insert(room);
		} else {
			return rm.orElseThrow(() -> new RoomNotFoundException("Dealer Already Exists"));
		}
	}

	@Override
	public Room updateRoom(Room room)throws RoomNotFoundException {
		log.info("Update Room Method Started");
		Optional<Room> rm = roomRepository.findById(room.getRoomNumber());
		if(!rm.isPresent())
			return rm.orElseThrow(
					()-> new RoomNotFoundException("Room with the id " + room.getRoomNumber()+" Doesn't Exists"));
		log.info("Update Room Method Ended");
		return roomRepository.save(room);
	}

	@Override
	public String deleteRoom(String id)throws RoomNotFoundException {
		log.info("Delete Room Method Started");
		Optional<Room> room = roomRepository.findById(id);
		if (!room.isPresent()) {
			room.orElseThrow(() -> new RoomNotFoundException("Room with the id " + id + " Doesn't Exists"));
		} else {
			roomRepository.deleteById(id);
			log.debug("Deleted SuccessFully {}", room);
			log.info("Delete Room Method Ended");
		}
		return "Room with the " + id + " Deleted Successfully!";
	}
	}
