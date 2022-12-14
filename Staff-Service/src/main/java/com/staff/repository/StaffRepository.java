package com.staff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.staff.model.Staff;

@Repository

public interface StaffRepository extends MongoRepository<Staff, Integer> {

}
