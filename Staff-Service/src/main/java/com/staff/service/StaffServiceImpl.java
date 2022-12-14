package com.staff.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.exception.StaffNotFoundException;
import com.staff.model.Staff;
import com.staff.repository.StaffRepository;




@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepo;
	
	Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);
	
	@Override
	public List<Staff> showAllStaffDetails() {
		log.info("Show All Staff Details Method Started");
		List<Staff> staff = staffRepo.findAll();
		log.debug("Staff are {} ", staff);
		log.info("Show All Staff Details Method Ended");
		return staff;
	}

	@Override
	public Staff showStaffById(int id) throws StaffNotFoundException {
		log.info("Show Staff By Id Method Started");
		return staffRepo.findById(id).orElseThrow(() -> new StaffNotFoundException("Staff with the id " + id + " Doesn't Exists"));
		
	}

	@Override
	public Staff addStaffDetails(Staff staff) throws StaffNotFoundException{
		log.info("Add StaffDetails Method Started");
		Optional<Staff> s = staffRepo.findById(staff.getId());
		if (!s.isPresent()) {
			log.info("Add StaffDetails Method Ended");
			return staffRepo.insert(staff);
		} else {
			return s.orElseThrow(() -> new StaffNotFoundException("Dealer Already Exists"));
		}

	}


	@Override
	public Staff updateStaffDetails(Staff staff)throws StaffNotFoundException {
		log.info("Update Staff Method Started");
		Optional<Staff> s = staffRepo.findById(staff.getId());
		if (!s.isPresent())
			return s.orElseThrow(() -> new StaffNotFoundException("Farmer with the id " + staff.getId() + " Doesn't Exists"));
		log.info("Update Dealer Method Ended");
		return staffRepo.save(staff);
	}

	@Override
	public String deleteStaffDetails(int id)throws StaffNotFoundException {
		log.info("Delete Staff Details Method Started");
		Optional<Staff> staff = staffRepo.findById(id);
		if (!staff.isPresent()) {
			staff.orElseThrow(() -> new StaffNotFoundException("Staff with the id " + id + " Doesn't Exists"));
		} else {
			staffRepo.deleteById(id);
			log.debug("Deleted SuccessFully {}", staff);
			log.info("Delete Staff Method Ended");
		}
		return "Staff with the " + id + " Deleted Successfully!";
	}

}
