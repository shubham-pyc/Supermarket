package controller;

import java.io.Serializable;
import java.util.ArrayList;

import models.supermarket.Product;
import models.supermarket.ProductBuilder;
import models.supermarket.SuperMarket;
import models.users.Customer;
import models.users.Employee;
import services.Configuration;
import services.FileSystem;
import services.Statement;
import view.SuperMarketView;

public class SuperMarketController implements Serializable{
	private SuperMarket model;
	private SuperMarketView view;
	public SuperMarketController(SuperMarket market,SuperMarketView view){
		this.model = market;
		this.view = view;
	}
	public boolean showProducts(){
		return view.showProdcuts(model.getProducts(),this);		
		
	}
	public void showCustomer(){
		view.showCustomers(model.getCustomers());
	}
	public void showEmployees(){
		Statement s = new Statement();
		s.createTable(model.getEmployees());
	}
	public void addProduct(Product product)
	{
		model.addProdcut(product);
	}
	public void removeProduct(Product prodcut){
		ArrayList<Product> list = model.getProducts();
		int index = list.indexOf(prodcut);
		list.remove(index);
	}
	public void addCustomer(Customer customer){
		ArrayList<Customer> list = model.getCustomers();
		
		list.add(customer);
	}
	public void addEmployee(Employee employee){

		ArrayList<Employee> list = model.getEmployees();
		list.add(employee);
	}
	public void welcome(){
		view.welcome(this);
	}
	public void start(){
		view.start(this);
	}
	public Customer findCustomer(String name){
		for(Customer cus:model.getCustomers()){
			if(cus.getName().equals(name)){
				return cus;
			}
		}
		return null;
	}
	public Employee findEmployee(String name){
		for(Employee emp:model.getEmployees()){
			if(emp.getName().equals(name)){
				return emp;
			}
		}
		
		return null;
	}
	public Product findProduct(String name,int quant){
		for(Product pro:model.getProducts()){
			if(pro.getName().equals(name)&& quant<=pro.getQuant()){
				
				return this.reduceQuant(pro, quant);
			}
		}
		return null;
	}
	public Product findProduct(String name){
		for(Product pro:model.getProducts()){
			if(pro.getName().equals(name)){
				
				return pro;
			}
		}
		return null;
	}
	
	public Product reduceQuant(Product p,int qunt){
		int avai = p.getQuant();
		if(qunt <= p.getQuant()){
			p.setQuant(avai-qunt);
			if(p.getQuant()<=0){
				ArrayList<Product> list = model.getProducts();
				int index = list.indexOf(p);
				list.remove(index);
			}
			return new ProductBuilder().setName(p.getName()).setPrice(p.getPrice()).setQuant(qunt).build();
			
		}
		return null;
	}
	public void save(){
		FileSystem file = new FileSystem();
		file.save(model);
	}
	public Configuration getConfiguration(){
		return model.getConfig();
	}


}
