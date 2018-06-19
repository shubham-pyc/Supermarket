package view;

import java.io.Console;
import java.util.Scanner;

import models.users.Employee;
import models.users.EmployeeBuilder;
import controller.SuperMarketController;

public class EmployeeView implements UserView {
	static Scanner scan = new Scanner(System.in);
	
	public  void view(SuperMarketController obj){
		System.out.print("Are you an old Employee or a new Employee?\nanswer# ");
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
		System.out.println("Select Staff type:1)Admin \n2)Staff");
		int choice = scan.nextInt();
		String staff = (choice==1)?"admin":"staff";
		Console console = System.console();
		//String password = new String(console.readPassword("please set password: "));
		System.out.println("Enter password");
		String password = scan.next();
		Employee emp = new EmployeeBuilder().setAddress(address).setName(name).setPhone(phone).setPassword(password).setStaffType(staff).build();
		obj.addEmployee(emp);
		obj.save();
		System.out.println("New Employee Added Successfully");
		this.menu(obj);
	}
	public  void menu(SuperMarketController obj){
		System.out.println("Please Enter username or name of employee");
		String name = scan.next();
		//String password = new String(console.readPassword("Enter Password: "));
		System.out.println("Enter password: ");
		String password = scan.next();
		Employee current = obj.findEmployee(name);
		String type;
		if(current !=null){
			boolean flag = true;
			while(flag){
				type = current.login(password);
				if(type ==null){
					System.out.println("Invalid Password");
				}
				else{
					flag = false;
				}
			}
			int choice = 1;
			while(choice != -1)
			{
				System.out.println("Please Enter Choice:1)Add New Product\t2)Remove Product");
				choice = scan.nextInt();
				switch(choice){
				case 1:
					ProductView.addNewProductView(obj);
					obj.save();
					//add new product logic
					break;
				case 2:
					//remove product logic
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			}
			
		}
		else{
			System.out.println("Invalid username or name");
			this.menu(obj);
		}
	}
}
