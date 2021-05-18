package employee;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.CheckboxMenuItem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
	private Menu CMenu = Main.DefaultMenu;
	private int Role;
	private String search = null;
	public boolean hasquit = false;
	public boolean waiting = true;
	public Employee employee;
	
	
	private static Controller instance = new Controller();
	
	
	

	private Controller()
	{
	}
	
	public static Controller getCommandLine() {
		return instance;
	}
	
	public void interpretinput(Object input) throws IOException
	{
		if(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") )
		{
			Object[] parms = {0, 0, 0};
			CMenu.runChoice((String) input, parms);
		}
		String searches[] = input.toString().split(" ");
		if(input.toString().toLowerCase().equals("devmode"))
		{
			View.print("opening dev menu");
			this.openMenu(Main.DEVMENU);
		}
		else if(input.toString().toLowerCase().startsWith("search"))
		{
			

			if(searches.length == 1) {			
			View.print("You did not type anything");
			}
			//Searching
			else if(searches.length == 2){
			View.print("Searching for" + searches[1]);
			this.search = searches[1];
			waiting = false;
			}
			
		}
		else if (searches[0].equals("select") )
		{
			if(searches.length == 1)
			{
				View.print("select <Employee ID>");
			}
			else if(searches.length == 2) {
			selectEmployee(searches[1]);
			}
			else
			{
				View.print("Too many arguments, this command can only accept 1");
			}
		}
		else if(searches[0].toLowerCase().equals(search))
		{
			if(searches.length == 1)
			{
				View.print("Search <Thing to Search>");
			}
			
		}
		else if(searches[0].toLowerCase().equals("clearsearch"))
		{
			search = null;
			waiting = false;
		}
		else if(searches[0].toLowerCase().equals("return"))
		{
			if(Role == 1) {	
			this.openMenu(HumanResources.HrMain);
			waiting = false;
			}
			else if(Role == 2) {
				this.openMenu(Accounting.accMenu);
				waiting = false;
			}
			else if(Role == 3) {
				this.openMenu(Thirdparty.thrdMain);
				waiting = false;
			}
		}
		else if(searches[0].toLowerCase().equals("help"))
		{
			View.print("search <Search Term>, Searches the employee list for a term");
			View.print("clearsearch, Clears the search");
			View.print("quit, Saves and closes the program");
			View.print("return, Returns you to the main menu");
			View.print("select <ID>, Selects an employee for editing by their id");
			
		}
		else if(input.toString().toLowerCase().equals("quit")) {
			Save(Main.List, "savefile");
			hasquit = true;
			
			
		}
		
	}
	
	public void selectEmployee(String id)
	{
		Main.List.forEach(x ->{
			if(x.getId().toLowerCase().equals(id)) {
				this.employee = x;
				return;
			}
		});
		View.print("An employee with this id does not exist");
		
		
	}
	
	
	
	public Menu getCurrentMenu() {
		return CMenu;
	}

	public Menu openMenu(Menu menuName) {
		CMenu = menuName;
		return menuName;
	}
	
	@SuppressWarnings("resource")
	public String getUserInput() {
		Scanner in = new Scanner(System.in);
		if(!in.hasNext()) {return "Error";}
		String input = in.nextLine();
		
		try {
			
			this.interpretinput(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	
	
	//Should only be used once
	public void setRole(int r)
	{
		Role = r;	
	}
	
	
	public void print(Object x)
	{
		System.out.println(x);
	}
	

	
	
	//Micheal: save/load
	//George: Changed the saving format to correct a wrong input error
	//Micheal: save/load
	
	public void load(ArrayList<Employee> EmployeeList, String fileName) throws IOException {
		
		File myFile = new File(fileName+".txt");
		
		if(!myFile.exists())
		{
			System.out.println("File not found");
			myFile.createNewFile();
			return;
		}
		
		Scanner file = new Scanner(myFile);
		
		while(file.hasNext())
		{
			
			file.useDelimiter(";");
			
			String emp_id = file.next();
			String FirstName = file.next().trim();
			String LastName = file.next().trim();
			double pay = Double.parseDouble(file.next());
			double tax = Double.parseDouble(file.next());
			String medplan = file.next();
			String role = file.next();
			Double pention = Double.parseDouble(file.next());
			double vacationdays = Double.parseDouble(file.next());
			
			Employee x = new Employee(FirstName,LastName,emp_id,pay);
			x.setTax(tax);
			x.setBenifites(medplan);
			x.setVacationDays((int)vacationdays);
			x.setRole(role);
			x.setPention(pention);
			EmployeeList.add(x);
			
			int size=Integer.parseInt(file.next());
			if(size > 0) {
			
			for(int r=0; r==size;r++) {
				String name =file.nextLine();
				String date =file.nextLine();
				String note =file.nextLine();
				x.addIncidentReports(name, date, note);
				}
			
			}
			
			
			
			
		
			
		}//input loop
		
		file.close();
	}
	

	public void Save(ArrayList<Employee> EmployeeList,String fileName) throws IOException {
		
		System.out.println("Saved,Now Exiting...");
		FileWriter saveFile = new FileWriter(fileName+".txt");
		for(int i=0;i<EmployeeList.size();i++) {
			saveFile.write(EmployeeList.get(i).getId()+";");
			saveFile.write(EmployeeList.get(i).getFname()+";");
			saveFile.write(EmployeeList.get(i).getLname()+";");
			saveFile.write((double) EmployeeList.get(i).getSalary()+";");
			saveFile.write((double) EmployeeList.get(i).getTax()+";");
			saveFile.write((String) EmployeeList.get(i).getBenifites()+";");
			saveFile.write((String) EmployeeList.get(i).getRole()+";");
			saveFile.write((double) EmployeeList.get(i).getPention()+";");
			saveFile.write((double) EmployeeList.get(i).getVacationDays()+";");
			saveFile.write(EmployeeList.get(i).getIncidentCount()+";");
			incidentReport[] IL = EmployeeList.get(i).getIncidentReports();
		if(EmployeeList.get(i).getIncidentCount() > 0)
		{
			
			for(int j=0;j<EmployeeList.get(i).getIncidentCount();j++)
			{
				saveFile.write(IL[i].name + ";");
				saveFile.write(IL[i].date + ";");
				saveFile.write(IL[i].notes + ";");
				
			}
			
		}	
		//saveFile.write(System.lineSeparator());
		}
		saveFile.close();
	}
	
	
	public String getSearch()
	{
		return search;
	}
	
}