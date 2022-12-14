package com.staff.service;

import java.util.List;

import com.staff.exception.StaffNotFoundException;
import com.staff.model.Staff;

public interface StaffService {
	public List<Staff> showAllStaffDetails()throws StaffNotFoundException;
	public Staff showStaffById(int id) throws StaffNotFoundException;
	public Staff addStaffDetails(Staff staff) throws StaffNotFoundException;
	public Staff updateStaffDetails(Staff staff)throws StaffNotFoundException;
	public String deleteStaffDetails(int id) throws StaffNotFoundException;
}
