package services;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import models.supermarket.Cart;
import models.supermarket.Product;
import models.users.Customer;

public class Statement {
	public Statement(){
		
	}

	public static String statementTable(int spaces,int fields){
		int temp = spaces*fields + fields;
		return String.format("%"+temp+"s", " ").replace(" ", "=");
	}
	
	public<any>  boolean createTable(ArrayList<any> list){
		if(list.size()==0){
			System.out.println("Empty list");
			return false;
		}
		int spaces = 20;
		Object temp  = list.get(0);
		int fields = 0;
		try{
		 fields = Introspector.getBeanInfo(temp.getClass(),Object.class).getPropertyDescriptors().length;
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(statementTable(spaces,fields));
		for(int i=0;i<list.size();i++)
		{
			Object obj = list.get(i);
			try{
				BeanInfo info = Introspector.getBeanInfo(obj.getClass(),Object.class);
				PropertyDescriptor[] props = info.getPropertyDescriptors();
				
				if(i==0){
					for(PropertyDescriptor p:props){
						String name = p.getName();
						System.out.print(String.format("%-"+spaces+"s", name)+"|");
					}
					System.out.println();
				}
				
				for(PropertyDescriptor p:props){
					String name = p.getName();
					Method getter = p.getReadMethod();
					
					System.out.print(String.format("%-"+spaces+"s", getter.invoke(obj))+"|");
				}
				System.out.println();
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("here");
				}
		}
		System.out.println(statementTable(spaces,fields));
		return true;
	}
	
	
}
