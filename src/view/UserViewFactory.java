package view;

import java.lang.ClassNotFoundException;
public class UserViewFactory {
	public static UserView getUserView(String type){

		String instance = type.toUpperCase().charAt(0) + type.toLowerCase().substring(1, type.length()) +"View";
		try{
			
			Class<?> user = Class.forName("view."+instance);
			return (UserView)user.newInstance();
		}catch(ClassNotFoundException e){
			System.out.println("No such implemention found Kindly Implement "+instance+"()");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
