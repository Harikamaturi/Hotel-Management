package com.guestservice.jwt.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guestservice.jwt.jwtutil.User1;


public interface UserRepo extends MongoRepository<User1, String> {

	User1 findByUsername(String username);

}