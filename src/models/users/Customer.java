package models.users;
import java.util.ArrayList;

import models.supermarket.Cart;
import models.supermarket.Product;


public class Customer extends Person{
	private int customerId;
	private Cart cart;
	float total;
	
	Customer(){
		super();
		cart = new Cart();
	}
	Customer(String name,String address,long phone){
		super(name,address,phone);
		cart = new Cart();
	}
	public void buy(Product product){
		cart.addToCart(product);
	}
	public boolean removeProdcut(String productName,int quant){
		
		return cart.removeFromCart(productName,quant);
	}
	public float checkOut(){
		total = cart.checkOut();
		return total;
	}
	public Cart getCart(){
		return cart;
	}
	public int getCustomerId(){
		return customerId;
	}
	public void clearCart(){
		ArrayList<Product> list = cart.getProdcuts();
		list.clear();
	}
	@Override
	public String toString(){
		String details = "";
		details = "Name: "+this.getName()+"\nAddress: "+this.getAddress()+"\nPhone: "+this.getPhone()+"\nCustomerId: "+this.getCustomerId();
		return details;
	}
	
	
	
	
}
