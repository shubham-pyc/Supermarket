package models.supermarket;


//Builder Design Pattern to build Product object

public class ProductBuilder {
	private String name;
	private float price;
	private int productId;
	private int quant;
	public ProductBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public ProductBuilder setPrice(float price) {
		this.price = price;
		return this;
	}
	public ProductBuilder setProductId(int productId) {
		this.productId = productId;
		return this;
	}
	public ProductBuilder setQuant(int quant){
		this.quant = quant;
		return this;
	}
	public Product build(){
		return new Product(name,price,quant);
	}
	
	
}
