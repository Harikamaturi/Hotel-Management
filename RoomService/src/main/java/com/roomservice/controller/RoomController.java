package com.roomservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomservice.exception.RoomNotFoundException;
import com.roomservice.model.Room;
import com.roomservice.service.RoomServiceImplementation;

@RestController
@RequestMapping("/room")

public class RoomController {
	
	@Autowired
	private RoomServiceImplementation service;
	
   Logger log = LoggerFactory.getLogger(RoomController.class);
	
	@GetMapping("/all")
	public ResponseEntity<List<Room>> showAllRoom(){
             List<Room> room = service.showAllRoom();
             if(room.isEmpty()) {
     			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
     		}
     		log.debug("Rooms are {}",room);
     		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> showRoomDetailsById(@PathVariable("id") String id) throws RoomNotFoundException {
		Room room = service.showRoomById(id);
		if(room!=null) {
			log.debug("Room: {}",room);
			return new ResponseEntity<>(room, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addroom")
	public ResponseEntity<Room> addRoomDetails(@RequestBody Room room) throws RoomNotFoundException {
		@SuppressWarnings("unused")
		Room rm = service.addRoom(room);
		if(room!=null) {
			log.debug("Rooms: {}",room);
			return new ResponseEntity<>(room, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateroom")
	public ResponseEntity<Room> updateRoomDetails(@RequestBody Room room) throws RoomNotFoundException {
		@SuppressWarnings("unused")
		Room rm = service.updateRoom(room);
		if(room!=null) {
			log.debug("Rooms: {}",room);
			return new ResponseEntity<>(room, HttpStatus.CREATED);}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteroom/{id}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable("id") String id) throws RoomNotFoundException {
		service.deleteRoom(id);
		return new ResponseEntity<>("Room Deleted Successfully", HttpStatus.OK);
	}

}
