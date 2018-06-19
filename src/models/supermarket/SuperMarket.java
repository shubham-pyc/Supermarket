package models.supermarket;

import java.io.Serializable;
import java.util.ArrayList;

import services.Configuration;

import models.users.Customer;
import models.users.Employee;

public class SuperMarket implements Serializable {
	private ArrayList<Product> products;
	private ArrayList<Customer> customers;
	private ArrayList<Employee> employees;
	private Configuration config;
	public SuperMarket(){
		products = new ArrayList<>();
		customers = new ArrayList<>();
		employees = new ArrayList<>();
		config = new Configuration();
		
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void addProdcut(Product product) {
		products.add(product);
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public Configuration getConfig(){
		return config;
	}
	
	
	
}
