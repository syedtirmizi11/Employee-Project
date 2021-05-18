package employee;

import java.util.function.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





@SuppressWarnings("unused")
public class Main {

	//test menu
	static Menu DefaultMenu = new Menu("Default Menu", "What Department are you in?", "Human Resources", "Accounting", "3rd party", null, null);
	static Menu DEVMENU = new Menu("DevMenu", "Development mode", null, null, null, null, null);
	

	static ArrayList<Employee> List = new ArrayList<Employee>();

	public static void main(String[] args) throws IOException{	
	HumanResources.HrMenuInit();
	defaultMenuInit();
	Accounting.accMenu();
	Thirdparty.ThirdMainInit();
	DEVMENU.showList = true;
		
	Controller cl = Controller.getCommandLine();
	cl.load(List, "savefile");

	Menu menu = cl.openMenu(DefaultMenu);
	menuLoop();
}                
	public static void menuLoop(){
		Scanner ln = new Scanner(System.in);
		Controller cl = Controller.getCommandLine();
		
		while(cl.hasquit == false)
		{
			cl.waiting = true; // if you want it to skip the enter to continue, set this to false inside of you choice functionality
			View.clearHome();
			View.printMenuDetails(cl.getCurrentMenu());
			cl.getUserInput();
			
			
			if(cl.waiting == true)
			{
			View.print("Press Enter to continue");
			ln.nextLine();
			}
			
			
		}
	}

	
	
	
	
	
	//Default Menu Functionality
	public static void defaultMenuInit() {
	Consumer<Object[]> ref1 = Main::defaultChoice1;
	DefaultMenu.setChoiceFunc("1", ref1);
	Consumer<Object[]> ref2 = Main::defaultChoice2;
	DefaultMenu.setChoiceFunc("2", ref2);
	Consumer<Object[]> ref3 = Main::defaultChoice3;
	DefaultMenu.setChoiceFunc("3", ref3);
	}
	
	
	public static void defaultChoice1(Object[] parms) {
	Controller cl = Controller.getCommandLine();
	View.clearHome();
	View.print("Confirmed, your role is human resources");
	cl.setRole(1);
	cl.openMenu(HumanResources.HrMain);
	}
	
	public static void defaultChoice2(Object[] parms) {
	Controller cl = Controller.getCommandLine();
	View.clearHome();
	View.print("Confirmed, your role is human resources");
	cl.setRole(2);
	cl.openMenu(Accounting.accMenu);
	}
	
	public static void defaultChoice3(Object[] parms) {
	Controller cl = Controller.getCommandLine();
	View.clearHome();
	View.print("Confirmed, your role is human resources");
	cl.setRole(3);
	cl.openMenu(Thirdparty.thrdMain);
	}
	
	public static ArrayList<Employee> getEmpList()
	{
		return List;
	}
	
	
	
}