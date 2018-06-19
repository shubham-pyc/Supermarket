package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import models.supermarket.Product;
import models.users.Customer;
import services.Configuration;
import services.Statement;
import controller.SuperMarketController;

public class SuperMarketView implements Serializable{
	static Scanner scan = new Scanner(System.in);
	Statement s = new Statement();
	public  void welcome(SuperMarketController obj){

		System.out.println("Hello welcome to SuperMarket");
		System.out.print("Loading please wait");
			try{
				for(int i=0;i<10;i++){
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(500);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("\nDone!");
			this.start(obj);
			
		
	}
	public void start(SuperMarketController obj){
		Configuration config = obj.getConfiguration();
		UserView view = config.userMenu();
		
		if(view != null)
			view.view(obj);
		else
			System.out.println("Something Went Wrong");
	}

	
	public boolean showProdcuts(ArrayList<Product> list,SuperMarketController controller){
	
		return s.createTable(list);
		
		
	}
	public void showCustomers(ArrayList<Customer> list){
		s.createTable(list);
	}
	
}

/* start() method is called where all the data flow starts; 
 * start methods lets the user choose from if the users wants to login into a customer account or a employee account 
 * */
