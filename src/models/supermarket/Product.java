package models.supermarket;

import java.io.Serializable;

public class Product implements Serializable {
	private String name;
	private float price;
	private int productId;
	private int quant;
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	Product(String name,float price,int quant){
		this.price = price;
		this.name = name;
		this.quant = quant;
		this.productId = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
