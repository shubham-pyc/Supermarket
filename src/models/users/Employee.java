package models.users;

public class Employee  extends Person{
	int employeeId;
	String staffType,password;
	
	public Employee(String name,String address,long phone,String staffType,String password){
		super(name,address,phone);
		this.staffType = staffType;
		this.password = password;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	
	public String login(String password){
		if(password.equals(this.password)){
			return staffType;
		}
		else{
			System.out.println("Invalid Password");
		}
		return null;
	}
	public boolean adminLogin(String password){
		String type =this.login(password);
		if(type!=null && type.equalsIgnoreCase("admin")){
			return true;
		}else{
			System.out.println("You are not an Admin");
		}
		return false;
		
	}
	
}
