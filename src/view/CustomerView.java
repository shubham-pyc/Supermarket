package view;

import java.util.Scanner;

import models.supermarket.Product;
import models.users.Customer;
import models.users.CustomerBuilder;
import controller.SuperMarketController;

public class CustomerView implements UserView{
	static Scanner scan = new Scanner(System.in);
	
	public  void view(SuperMarketController obj){
		System.out.print("Are you an old customer or a new customer?\nanswer# ");
		String answer = scan.next().toLowerCase();
		switch(answer){
			case "new":
					this.register(obj);
					break;
			case "old":
					this.menu(obj);
					break;
			default:
				System.out.println("Invalid choice please try again");
				this.view(obj);
				break;
		}
	}
	public  void register(SuperMarketController obj){
		System.out.print("Please Enter Details:\nName: ");
		String name = scan.next();
		System.out.print("Address: ");
		String address = scan.next();
		System.out.print("Phone Number: ");
		long phone = scan.nextLong();
		
		Customer cust = new CustomerBuilder().setName(name).setAddress(address).setPhone(phone).build();
		
		obj.addCustomer(cust);
		obj.save();
		System.out.println("New Customer Added Successfully");
		this.menu(obj);
		
	}
	public  void menu(SuperMarketController obj){
		System.out.println("Please Enter the name of the customer: ");
		String name = scan.next();
		Customer cus = obj.findCustomer(name);
		if(cus != null)
		{
			char c = 'y';
			
			while(c !='n'){
				System.out.print("Please Enter Choice: 1)View Products \t2)Show Cart\t 3)Remove Product\t4)Final Checkout\nchoice# ");
				int choice  = scan.nextInt();
				switch(choice){
					case 1:
						
						String productName = "";
						int quant = 0;
						boolean flag = true;
						while(flag)
						{
							boolean status = obj.showProducts();
							if(status)
							{
								System.out.println("Enter the name of the product to buy: ");
								productName = scan.next();
						
								System.out.println("Enter the Quantity to buy");
								quant = scan.nextInt();
								
								Product p = obj.findProduct(productName, quant);
								
								if(p==null){
									System.out.println("Invaild name or Quantity");
									System.out.println("Try again?(Y/N)");
									char cc = scan.next().toLowerCase().charAt(0);
									if(cc=='y')
										continue;
								}
								else{
									cus.buy(p);
								}
								System.out.println("Do you want to buy more products?(Y/N)");
								char cc = scan.next().toLowerCase().charAt(0);
								if(cc=='n'){
									flag = false;
									obj.save();
								}
							}
							else{
								flag = false;
							}
							
							
							
						}
						break;
					case 2:
						float total = cus.checkOut();
						System.out.println("Total Price: "+total);
						//Show Products in Cart View
						break;
					case 3:
						productName = "";
						quant = 0;
						flag = true;
						while(flag){
							cus.checkOut();
							System.out.println("Enter the Name of the product to remove from cart");
							productName = scan.next();
							System.out.println("Enter Quantity");
							quant = scan.nextInt();
							if(cus.removeProdcut(productName,quant)){
								flag = false;
							}
						}
						//call getStatement from services.Statement.java
						obj.save();
						break;
					case 4:
						float cTotal = cus.checkOut();
						System.out.println("Total Price: "+cTotal);
						cus.clearCart();
						obj.save();
						System.out.println("ThankYou for shopping with us....");
						obj.welcome();
						break;
						
					default:
						System.out.println("Invalid Choice");
						break;
				}
				System.out.println("Do you want to continue(Y/N)");
				c = scan.next().toLowerCase().charAt(0);
			}
			
		}
		else{
			System.out.println("Invalid name please try again");
			this.menu(obj);
		}
		
	}
}



/* this.view function is used to get input from the user if it is old customer or a new customer and accordingly call register customer or customer menu
 * 
 * registerCustomer function is used to register a new customer after registration customermenu is called
 *
 * customerMenu methods lets the user chose from the options to add or remove products in cart
 * 
 */