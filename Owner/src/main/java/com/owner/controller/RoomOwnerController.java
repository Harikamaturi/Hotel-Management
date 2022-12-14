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
import com.owner.exception.RoomNotFoundException;
import com.owner.feignclient.RoomFeignClient;
import com.owner.model.Room;

@RestController
@RequestMapping("owner/room")
public class RoomOwnerController {
	@Autowired
	private RoomFeignClient roomFeignClient;

	@GetMapping("/all")
	public ResponseEntity<List<Room>> showAllRoom(@RequestHeader("Authorization") String token) {
		return roomFeignClient.showAllRoom(token);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Room> showRoomById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
		return roomFeignClient.showById(id, token);
	}

	@PostMapping("/addroom")
	public ResponseEntity<Room> addRoom(@RequestBody Room roomDetails,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
		return roomFeignClient.addRoom(roomDetails, token);
	}

	@PutMapping("/updateroom")
	public ResponseEntity<Room> updateRoom(@RequestBody Room roomDetails,@RequestHeader("Authorization") String token) throws RoomNotFoundException {

		return roomFeignClient.updateRoom(roomDetails, token);
	}

	@DeleteMapping("/deleteroom/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
		return roomFeignClient.deleteRoom(id, token);
	}

}
