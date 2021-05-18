package employee;

import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Accounting {
	
	Menu accMenu = new Menu("Accounting", "", "Edit salary", "Edit Tax", "Edit MedPlan", "Edit Pention", null);
	
	public static void accMenu()
	{
		accMenu.showList = true;

		Consumer<Object[]> ref1 = Accounting::Salary;
		accMenu.setChoiceFunc("1", ref1);
		
		Consumer<Object[]> ref2 = Accounting::Tax;
		accMenu.setChoiceFunc("2", ref2);
		
		Consumer<Object[]> ref3 = Accounting::medplan;
		accMenu.setChoiceFunc("3", ref3);
		
		Consumer<Object[]> ref4 = Accounting::Pention;
		accMenu.setChoiceFunc("4", ref4);
		
	}
	public static void Salary(Object[]parms) {
		Controller cl= Controller.getCommandLine();
		List<Employee> EmployeeList = Main.List;

		Employee emp = cl.employee;
		if(cl.employee!= null) {
			
		
		Scanner kb = new Scanner(System.in);
		View.print("Enter Employee's new Salary");
		double newsalary =Double.parseDouble(kb.next());
		cl.employee.setSalary(newsalary); 
		}
		 else{
			 View.print("you need add an employee");
			 return;}
	
		}
	
	
		public static void Tax(Object[]parms) {
			Controller cl= Controller.getCommandLine();
			List<Employee> EmployeeList = Main.List;
			Scanner kb = new Scanner(System.in);
			Employee emp = cl.employee;
			
			if(cl.employee!= null) {
			View.print("Enter Employee's taxes");
			double tax =Double.parseDouble(kb.nextLine());
			cl.employee.setTax(tax); 
			}
			 else{
				 View.print("you need add an employee");
				 return;}
		}
		
			public static void medplan(Object[]parms) {
				Controller cl= Controller.getCommandLine();
				List<Employee> EmployeeList = Main.List;
				Employee emp = cl.employee;
				
				if(cl.employee!= null) {
				Scanner kb = new Scanner(System.in);
				View.print("Enter Employee's medplan");
				String newmedplan =kb.nextLine();
				cl.employee.setBenifites(newmedplan); 
				}
				 else{
					 View.print("you need add an employee");
					 return;}
			
	
				}
			
			public static void Pention(Object[]parms) {
				Controller cl= Controller.getCommandLine();
				List<Employee> EmployeeList = Main.List;
				Scanner kb = new Scanner(System.in);
				Employee emp = cl.employee;
				
				if(cl.employee!= null) {
				View.print("Enter Employee's pention");
				double Pention =Double.parseDouble(kb.nextLine());
				cl.employee.setTax(Pention); 
				}
				 else{
					 View.print("you need add an employee");
					 return;}
			}
		
}	


			