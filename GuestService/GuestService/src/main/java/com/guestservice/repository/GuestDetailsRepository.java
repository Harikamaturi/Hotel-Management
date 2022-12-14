package com.guestservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guestservice.model.GuestDetails;
@Repository
public interface GuestDetailsRepository extends MongoRepository<GuestDetails,Integer>{

}
