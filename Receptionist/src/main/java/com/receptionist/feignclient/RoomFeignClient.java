package com.receptionist.feignclient;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.receptionist.model.Room;

@FeignClient(name="room-service", url="http://localhost:9001/room")
public interface RoomFeignClient {
							
			@GetMapping("/all")
			public ResponseEntity<List<Room>> showAllRoom();
			
			@GetMapping("/{id}")
			public ResponseEntity<Room> showRoomById(int id);
}
