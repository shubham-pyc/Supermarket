package models.users;

import java.util.Date;

import models.supermarket.Cart;

public class EmployeeBuilder {
	String name,address,staffType,password;
	long phone;
	Date dob;
	private int employeeId;

	public EmployeeBuilder(){
		
	}
	public EmployeeBuilder setName(String name) {
		this.name = name;
		return this;
		
	}
	public EmployeeBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	public EmployeeBuilder setPhone(long phone) {
		this.phone = phone;
		return this;
	}
	public EmployeeBuilder setDob(Date dob) {
		this.dob = dob;
		return this;
	}
	public EmployeeBuilder setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	public EmployeeBuilder setStaffType(String staffType){
		this.staffType = staffType;
		return this;
	}
	public EmployeeBuilder setPassword(String password){
		this.password= password;
		return this;
	}
	
	
	public Employee build(){
		return new Employee(name,address,phone,staffType,password);
	}
}
