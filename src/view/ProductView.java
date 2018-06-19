package view;

import java.util.ArrayList;
import java.util.Scanner;

import models.supermarket.Product;
import models.supermarket.ProductBuilder;
import controller.SuperMarketController;

public class ProductView {
	static Scanner scan = new Scanner(System.in);
	
	public static Product showProducts(ArrayList<Product> list){
		System.out.println("================================================");
		System.out.println(String.format("%-15s", "Product Name")+"|"+String.format("%-15s","Price")+"|"+String.format("%-15s","Available Quantity")+"|");
		for(int i=0;i<list.size();i++){
			System.out.println(String.format("%-15s",list.get(i).getName())+"|"+String.format("%-15s", list.get(i).getPrice())+"|"+String.format("%-15s", list.get(i).getQuant())+"|");
		}
		System.out.println("================================================");
		Scanner scan = new Scanner(System.in);
		String choice = "";
		int quant = 0;
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter the name of the product to buy: ");
			choice = scan.next();
	
			System.out.println("Enter the Quantity to buy");
			quant = scan.nextInt();
			
		}
		
		return null;
	}

	public static void addNewProductView(SuperMarketController obj){
		System.out.println("Please Enter the name of the product");
		String name = scan.next();
		System.out.println("Please enter the price of the prodcut");
		float price = scan.nextFloat();
		System.out.println("Please enter the quantity of the product available");
		int quant = scan.nextInt();
		
		Product pro = obj.findProduct(name);
		if(pro !=null){
			pro.setQuant(pro.getQuant()+quant);
		}
		else{
			Product newProduct = new ProductBuilder().setName(name).setPrice(price).setQuant(quant).build();
			obj.addProduct(newProduct);
			
		}
		System.out.println("Product added successfully");
	}
}
