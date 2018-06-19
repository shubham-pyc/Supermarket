package models.users;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable  {
	String name,address;
	long phone;
	Date dob;
	
	Person(){		
	}
	
	Person(String name,String address,long phone){
		this.name  = name;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
