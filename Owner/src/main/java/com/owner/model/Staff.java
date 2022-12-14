package com.owner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff")
public class Staff {
	@Id
	private int id;
	private int departmentId;
	private String employeeName;
	private String phoneNo;
	private String email;
	private int age;
	private String employeeAddress;
	private int salary;

	public Staff(int id, int departmentId, String employeeName, String phoneNo, String email, int age,
			String employeeAddress, int salary) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.employeeName = employeeName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.age = age;
		this.employeeAddress = employeeAddress;
		this.salary = salary;
	}

	public Staff() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", departmentId=" + departmentId + ", employeeName=" + employeeName + ", phoneNo="
				+ phoneNo + ", email=" + email + ", age=" + age + ", employeeAddress=" + employeeAddress + ", salary="
				+ salary + "]";
	}

}