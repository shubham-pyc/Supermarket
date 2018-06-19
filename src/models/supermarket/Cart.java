package models.supermarket;

import java.io.Serializable;
import java.util.ArrayList;

import services.Statement;
public class Cart implements Serializable {
	ArrayList<Product> products = new ArrayList<>();
	public void addToCart(Product product){
		products.add(product);
		
	}
	
	public boolean removeFromCart(String name,int quant){
		
		for(int i=0;i<products.size();i++){
			Product pro = products.get(i);
			if(pro.getName().equalsIgnoreCase(name)){
				if(quant>0 && quant<= pro.getQuant() ){
					if((pro.getQuant()-quant)<=0){
						//Remove a product if quantity if equal to zero
						products.remove(pro);
						
					}
					else{
						// if not just reduce the quantity of the product from the cart
						pro.setQuant(pro.getQuant()-quant);
						
					}
					return true;
				}
			}
		}
		System.out.println("Invalid Name or quantity of the product");
		return false;
	}
	
	public float checkOut(){
		float total = 0;
		Statement s = new Statement();
		s.createTable(products);
		for(Product p:products){
			total += p.getPrice()*p.getQuant();
		}
		return total;
	}
	public ArrayList<Product> getProdcuts(){
		return products;
	}
	
	@Override
	public String toString(){
		String statement = "";
		for(Product p:products){
			statement += p.getName() +" \n";
		}
		return statement;
	}
}
