package services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.supermarket.Cart;
import models.supermarket.Product;
import models.supermarket.SuperMarket;
import models.users.Person;

public class FileSystem {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	public<any>  boolean save(any obj){
		try{
			String path = "";
			if(obj instanceof Person)
				path = "person.ser";
			else if(obj instanceof Product)
				path = "product.ser";
			else if(obj instanceof Cart)
			{
				path = "cart.ser";
			}
			else if(obj instanceof SuperMarket)
				path = "market-v1.ser";
			FileOutputStream fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public<any> any read(String obj)throws IOException{
		String filePath = "";
		try{
			
			if(obj.toLowerCase().equals("market"))
				filePath = "market-v1.ser";
			else if(obj.toLowerCase().equals("product"))
				filePath = "products.ser";
			else if(obj.toLowerCase().equals("cart"))
				filePath = "cart.ser";
			
			
			
			FileInputStream fis = new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			any person = (any)ois.readObject();
			return person;
		}catch(FileNotFoundException  e){
			System.out.println("File not found clearing a new file");
			File newFile = new File(filePath);
			newFile.createNewFile();
			newFile.exists();
			return null;
		} catch(ClassNotFoundException e){
			System.out.println("No such class found");
		}
		return null;
		
	}
}
