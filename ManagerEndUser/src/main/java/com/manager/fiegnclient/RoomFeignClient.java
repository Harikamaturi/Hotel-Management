package com.manager.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manager.exception.RoomNotFoundException;
import com.manager.model.Room;


@FeignClient(name="Room-Service" , url="http://localhost:9001/room")
public interface RoomFeignClient {

		@PostMapping("/addRoomDetails")
		public ResponseEntity<Room> addRoomDetails(@RequestBody Room roomDetails) throws RoomNotFoundException;
			
		
		@PutMapping("/updateRoomDetails")
		public ResponseEntity<Room> updateRoomDetails(@RequestBody Room roomDetails) throws RoomNotFoundException;
		
		@DeleteMapping("/deleteRoomDetails/{id}")
		public ResponseEntity<String> deleteRoomDetails(@PathVariable("id") int id) throws RoomNotFoundException;
		
	}



