package employee;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.*;
public interface HumanResources {

	

	//we can improve these when the search methods are done
	static Menu HrMain = new Menu("Human Resources", "", "Hire Employee","Fire a Employee" , "view incident report", "Edit Employee","Add Incident Report");
	public static void HrMenuInit()
	{
		HrMain.showList = true;
		Consumer<Object[]> ref1 = HumanResources::Hire;
		HrMain.setChoiceFunc("1", ref1);
		
		Consumer<Object[]> ref2 = HumanResources::Fire;
		HrMain.setChoiceFunc("2", ref2);
		
		Consumer<Object[]> ref3 = HumanResources::PrintIncidentReports;
		HrMain.setChoiceFunc("3", ref3);
		
		Consumer<Object[]> ref4 = HumanResources::Edit;
		HrMain.setChoiceFunc("4", ref4);
		
		Consumer<Object[]> ref5 = HumanResources::AddIncidentReport;
		HrMain.setChoiceFunc("5", ref5);
		FireMenu();
	}
	
	public static void Edit(Object[] parms) {
		Controller cl = Controller.getCommandLine();
		cl.openMenu(EditMenu);
	}
	
	public static void PrintIncidentReports(Object[] parms) {
		
		Controller cl = Controller.getCommandLine();
		Employee emp = cl.employee;
			View.print(cl.employee.getAllIncidentReports());
		}
		
	
	
	static Menu EditMenu = new Menu("Edit Menu", "", "edit first Name", "Edit Last Name", "Edit Vacation Days", "Edit role","edit medplan");
	public static void FireMenu()
	{
		Consumer<Object[]> ref1 = HumanResources::EditFName;
		EditMenu.setChoiceFunc("1", ref1);
		
		Consumer<Object[]> ref2 = HumanResources::EditLName;
		EditMenu.setChoiceFunc("2", ref2);
		
		Consumer<Object[]> ref3 = HumanResources::EditVactionDays;
		EditMenu.setChoiceFunc("3", ref3);
		
		Consumer<Object[]> ref4 = HumanResources::Editrole;
		EditMenu.setChoiceFunc("4", ref4);
		
		Consumer<Object[]> ref5 = HumanResources::EditMedplan;
		EditMenu.setChoiceFunc("5", ref5);
		
	}
	

	
	public static void Editrole(Object[] parms) {

        Scanner kb = new Scanner(System.in);
        Controller cl = Controller.getCommandLine();
        Employee emp = cl.employee;
        if(cl.employee!= null) {
            View.print("enter employees new role");
            String role=kb.nextLine();
            cl.employee.setRole(role);
        }
         else{
             View.print("you need add an employee");
             return;}

    }
    //edit medplan

public static void EditMedplan(Object[] parms) {

        Scanner kb = new Scanner(System.in);
        Controller cl = Controller.getCommandLine();
        Employee emp = cl.employee;
        if(cl.employee!= null) {
            View.print("enter employees new medplan");
            String medplan=kb.nextLine();
            cl.employee.setBenifites(medplan);
        }
}
	public static void EditFName(Object[] parms) {
        Controller cl = Controller.getCommandLine();
        Employee emp = cl.employee;
        if(cl.employee!= null) {


        Scanner kb = new Scanner(System.in);
        ArrayList<Employee> EmployeeList = Main.List;
        View.print("Enter Employee's new fist Name");
        String newFName =kb.nextLine();
        cl.employee.setFname(newFName); 
         }
         else{
             View.print("you need add an employee");
             return;}
    }
	public static void EditLName(Object[] parms) {
		Controller cl = Controller.getCommandLine();
		Employee emp = cl.employee;
		if(cl.employee!= null) {
		Scanner kb = new Scanner(System.in);
		ArrayList<Employee> EmployeeList = Main.List;
		View.print("Enter Employee's new Last Name");
		String newLName =kb.nextLine();
		cl.employee.setLname(newLName); 
		 }
		 else{
			 View.print("you need add an employee");
			 return;}
	}
	
	
	//general fire
	public static void Fire(Object[] parms) {

        Controller cl = Controller.getCommandLine();
        Employee emp = cl.employee;
         if(cl.employee!= null) {

        Scanner kb = new Scanner(System.in);
        ArrayList<Employee> EmployeeList = Main.List;
        View.print("employee has been removed"+cl.employee);
        Main.List.remove(cl.employee);
         }
         else{
             View.print("You need to select an employee, use help if you need a list of commands");
             return;}
    }

	
	//Hire Employee
	public static void Hire(Object[] parms) {
		ArrayList<Employee> EmployeeList = Main.List;
		 Scanner kb = new Scanner(System.in);
		 View.print("Enter employee's First name: ");
			String Fname = kb.nextLine();
			View.print("Enter employee's Last name: ");
			String Lname = kb.nextLine();
			View.print("Enter id: ");
			String emp_id = kb.nextLine();
			
			if(Main.List.size() > 0) {
			boolean found=false;
			for(int i=0;i<EmployeeList.size();i++) {
				if(EmployeeList.get(i).getId()==emp_id) {
					View.print("Error: id already exists");
					found = true;
					return;
				}
			}
			}
				View.print("Enter Employee role");
				String role=kb.nextLine();
				View.print("Enter Employee pay");
				double pay = kb.nextDouble();
				View.print("Enter Employee tax");
				double tax=kb.nextDouble();
				View.print("Enter amount of Employee vacation days");
				double vacationdays = Double.parseDouble(kb.next());
				kb.nextLine();
				View.print("Enter Employee benifits");
				String ben=kb.nextLine();
				View.print("Enter Employee pention");
				double Pention = kb.nextDouble();

				
				Employee x = new Employee(Fname,Lname,emp_id,pay);
				x.setVacationDays((int)vacationdays);
				x.setSalary(pay);
				x.setTax(tax);
				x.setBenifites(ben);
				x.setRole(role);
				x.setPention(Pention);
				Main.List.add(x);
		
	}	
		
	public static void AddIncidentReport(Object[] parms) {
		Controller cl = Controller.getCommandLine();
		Employee emp = cl.employee;
		 if(cl.employee!= null) {
		
		 Scanner kb = new Scanner(System.in);
	
		View.print("What is the name of the incident");
		String name = kb.nextLine();
		View.print("Whats the date of incident accured for this report?");
		
		String date = kb.nextLine();
		
		View.print("Give a brief discription of the incident and who was involved");
		String note = kb.nextLine();
		
		cl.employee.addIncidentReports(name, date, note);
		 }
		 else{
			 View.print("you need add an employee");
			 return;}
		
			}
	
	
	
	public static void EditVactionDays(Object[] parms){
		Controller cl = Controller.getCommandLine();
		Employee emp = cl.employee;
		 if(cl.employee!= null) {
		 Scanner kb = new Scanner(System.in);
		 View.print("enter employees vacation day");
		 int VacationDays = kb.nextInt();
		 cl.employee.setVacationDays(VacationDays);
		 }
		 else{
			 View.print("you need add an employee");
			 return;}
	}
	
}
