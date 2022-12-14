package com.reservation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Reservation;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation,Integer> {

}
