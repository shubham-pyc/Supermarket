package models.users;

import java.util.Date;

import models.supermarket.Cart;

public class CustomerBuilder {
	String name,address;
	long phone;
	Date dob;
	private int customerId;
	private Cart cart;
	public CustomerBuilder(){
		
	}
	public CustomerBuilder setName(String name) {
		this.name = name;
		return this;
		
	}
	public CustomerBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	public CustomerBuilder setPhone(long phone) {
		this.phone = phone;
		return this;
	}
	public CustomerBuilder setDob(Date dob) {
		this.dob = dob;
		return this;
	}
	public CustomerBuilder setCustomerId(int customerId) {
		this.customerId = customerId;
		return this;
	}
	public CustomerBuilder setCart(Cart cart) {
		this.cart = cart;
		return this;
	}
	public Customer build(){
		return new Customer(name,address,phone);
	}
}
