package services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import view.UserView;
import view.UserViewFactory;

public class Configuration implements Serializable{
	List<String> userTypeList = new ArrayList<>();
	public Configuration(){
		this.addUserType("customer");
		this.addUserType("employee");
		this.addUserType("admin");
	}
	public void addUserType(String type){
		type = type.toLowerCase();
		if(userTypeList.indexOf(type)==-1)
			userTypeList.add(type);
		else
			System.out.println("Category already found");
	}
	public void removeUserType(String type){
		type = type.toLowerCase();
		if(userTypeList.indexOf(type) != -1){
			userTypeList.remove(type);
		}
		else{
			System.out.println("No Such Category found");
		}
	}
	public  UserView getUserType(int index){
		return UserViewFactory.getUserView(userTypeList.get(index));
	}
	public UserView userMenu(){
		System.out.println("Please Enter choice: ");
		int i=0;
		for(String user:userTypeList){
			System.out.println(++i +") "+user);
		}
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		UserView user = null;
		if(choice<= userTypeList.size()){
			user = this.getUserType(choice-1);
		}
		else{
			System.out.println("Invalid Choice Please Try Again!");
			this.userMenu();
			
		}
		return user; 
		
	}
	
	
	
}
