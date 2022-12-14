package com.receptionist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receptionist.exception.RoomNotFoundException;
import com.receptionist.feignclient.RoomFeignClient;
import com.receptionist.model.Room;

@RestController
@RequestMapping("/room")

public class RoomController {
	
	@Autowired
	private RoomFeignClient roomFeignClient;

   
	@GetMapping("/all")
	public ResponseEntity<List<Room>> showAllRoom(){
     		return roomFeignClient.showAllRoom();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> showRoomById(@PathVariable("id") int id) throws RoomNotFoundException {
			return roomFeignClient.showRoomById(id);
	}

}
