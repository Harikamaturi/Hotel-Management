package com.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.exception.RoomNotFoundException;

import com.manager.fiegnclient.RoomFeignClient;

import com.manager.model.Room;


@RestController
@RequestMapping("/room")
public class RoomManagerController {
	@Autowired
	private RoomFeignClient roomClient;
	
	@PostMapping("/addRoomDetails")
	public ResponseEntity<Room> addRoomDetails(@RequestBody Room roomDetails) throws RoomNotFoundException {
		return roomClient.addRoomDetails(roomDetails);
	}
	@PutMapping("/updateRoomDetails")
	public ResponseEntity<Room> updateRoomDetails(@RequestBody Room roomDetails) throws RoomNotFoundException{
		return roomClient.updateRoomDetails(roomDetails);
	}
	@DeleteMapping("/deleteRoomDetails/{id}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable("id") int id) throws RoomNotFoundException{
		return roomClient.deleteRoomDetails(id);
	}

}
