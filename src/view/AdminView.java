package view;

import java.util.Scanner;

import models.users.Employee;
import services.Configuration;
import controller.SuperMarketController;

public class AdminView implements UserView {

	@Override
	public void register(SuperMarketController obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view(SuperMarketController obj) {
		System.out.println("Please Enter username or name");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		System.out.println("Please Enter password");
		String password = scan.next();
		Employee current = obj.findEmployee(name);
		if(current !=null){
			if(current.adminLogin(password)){
				this.menu(obj);
			}
		}else{
			System.out.println("Invalid Username");
			System.out.println("Do you want to try again?(Y/N)/n");
			char choice = scan.next().toLowerCase().charAt(0);
			if(choice=='y'){
				this.view(obj);
			}
			else{
				//Think about this;
				//GO back to SuperMarket. start method;
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menu(SuperMarketController obj) {
		// TODO Auto-generated method stub
		System.out.println("Welcome Admin.");
		System.out.println("Choose\n1)Add New User Category\n2)Remove User Category");
		Scanner scan = new Scanner(System.in);
		int choice =scan.nextInt();
		Configuration config = obj.getConfiguration();
		switch(choice){
			case 1:
				System.out.println("Enter the name of Category");
				String type = scan.next();
				config.addUserType(type);
				System.out.println("Category Added Successfully");
				break;
			case 2:
				System.out.println("Enter the Category to remove");
				String rType = scan.next();
				config.removeUserType(rType);
				
				System.out.println("Category removed Successfully");
				break;
			default:
				System.out.println("Invalid choice");
		}
		obj.save();
		obj.start();
		
	}

}
