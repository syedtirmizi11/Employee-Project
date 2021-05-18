package employee;

import java.io.IOException;
import java.util.ArrayList;

public class View {
		
	
	public static void printEmployeeList() {
		Controller cl = Controller.getCommandLine();
		String search = cl.getSearch();
		print("Employee List");
		print("-----------------------------------");
		for(int i=0;i<Main.List.size();i++)
		{
			if(search != null) {
				//String searches
			if(!Main.List.get(i).getFname().toLowerCase().startsWith(search.toLowerCase()) 
					&& !Main.List.get(i).getBenifites().toLowerCase().startsWith(search.toLowerCase()) 
					&& !Main.List.get(i).getLname().toLowerCase().startsWith(search.toLowerCase()) 
					&& !Main.List.get(i).getId().toLowerCase().startsWith(search.toLowerCase()) 
					&& !Main.List.get(i).getRole().toLowerCase().startsWith(search.toLowerCase()) 
					&& !String.valueOf(Main.List.get(i).getSalary()).startsWith(search)
					&& !String.valueOf(Main.List.get(i).getVacationDays()).startsWith(search)
					&& !String.valueOf(Main.List.get(i).getPention()).startsWith(search)){
				continue;
				}
			}
			System.out.print(Main.List.get(i).getId() + " " + Main.List.get(i).getFname() +" "+ Main.List.get(i).getLname());
			System.out.print(" " + Main.List.get(i).getRole() + " ");
			System.out.print("$"+Main.List.get(i).getSalary());
			System.out.print(" " + Main.List.get(i).getTax() + "% ");
			System.out.print(Main.List.get(i).getPention() + " ");
			System.out.print(Main.List.get(i).getVacationDays() + " ");
			System.out.print(Main.List.get(i).getBenifites() + " ");
			System.out.print(Main.List.get(i).getVacationDays());
			
			System.out.print("\n");
	}
		
		print("-----------------------------------");
		
}
	
	
	public static void printEmployeeDetails(String fname, String lname, String id, double salary, double tax,
			String medplan, int vacationDays) {
		  System.out.println("Employee Name: " + fname + lname);
	      System.out.println("Employee ID " + id);
	      System.out.println("Employee Salary" + salary);
	      System.out.println("Percentage Tax " + tax);
	      System.out.println("Employee's medical plan " + medplan);
	      System.out.println("Number of Vacation day " + vacationDays);
		
	}
	public static void printControllerDetails(Menu CMenu, int Role) {
	      System.out.println("Menu" + CMenu);
	      System.out.println("Employee's Role" + Role);
	      
	}
	public static void printMenuDetails(Menu menu) {
		  Controller cl = Controller.getCommandLine();
	      System.out.println(menu.getMenuName());
	      System.out.println(menu.getMenuText());
	      if(menu.showList == true) {
	      printEmployeeList();
	      	if(cl.employee != null)
	      	print("Selected Employee: " + cl.employee.getFname() + " " + cl.employee.getLname());
	      	else
	      	print("Selected Employee: None");
	      }
	      
	      System.out.println(menu.getMenuChoices());
	      //System.out.println(choice2);
	      //System.out.println(choice3);
	      //System.out.println(choice4);
	      //System.out.println(choice5);


	}
	
	
	
	
	
	public static void print(Object x)
	{
		System.out.println(x);
	}
	
	public static void clearHome()
	{
		try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } 
		catch (IOException | InterruptedException ex) 
		{}
	}
	
	
}

