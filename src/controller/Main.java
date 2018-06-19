package controller;
import java.io.FileNotFoundException;

import models.supermarket.SuperMarket;
import services.FileSystem;
import view.SuperMarketView;


public class Main {
	public static void main(String ...ar){
		FileSystem db = new FileSystem();
//		Product cookies = new ProductBuilder().setName("cookies").setPrice(10).setQuant(10).build();
//		Product milk = new ProductBuilder().setName("Milk").setPrice(500).setQuant(10).build();
//		Product shoes = new ProductBuilder().setName("shoes").setPrice(500).setQuant(10).build();		
		SuperMarket walmart;
		
		try{
			walmart = db.read("market");
			
		}catch(Exception e){
			System.out.println("No data found");
			walmart = new SuperMarket();
			
			
		}
		if(walmart==null){
			walmart = new SuperMarket();
			System.out.println("New DB created");
		}
		
		SuperMarketView view = new SuperMarketView();
		SuperMarketController controller = new SuperMarketController(walmart,view);
		controller.save();
		controller.welcome();
		
	
		
	}
}
