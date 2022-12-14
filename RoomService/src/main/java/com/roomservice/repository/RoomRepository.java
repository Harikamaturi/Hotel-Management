package com.roomservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.roomservice.model.Room;
@Repository
public interface RoomRepository extends MongoRepository<Room,String> {

}
