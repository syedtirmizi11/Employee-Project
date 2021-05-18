package employee;

import java.util.function.*;
/*
Template for adding functionality to the choices

	Consumer<Object[]> ref = Main::menufunc;
	DefaultMenu.setChoiceFunc("1", ref);
	
	Object[] i = {0, "hello", 'g'};
	DefaultMenu.runChoice(1, i);
	
Note: have java.util.function.*; imported into the class your running
*/


public class Menu {
	private String Mname;
	private String menuText;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	public boolean showList = false;
	public Consumer<Object[]> choice1func = null;
	public Consumer<Object[]> choice2func = null;
	public Consumer<Object[]> choice3func = null;
	public Consumer<Object[]> choice4func = null;
	public Consumer<Object[]> choice5func = null;
	
/*
@param n: Them menu name, this must be unique to every other menu created.
@param m: the menu text that displays
@param c1 - c5: The string representation for the choices, their functionality will be tied to this.		
George: let me do this, its probably going to be convoluted but i want to design it this way so that 
we can create exclusive menus for each interface, also c2 - c5 are optional.
*/
	public Menu(String n, String m, String c1, String c2, String c3, String c4, String c5) {
		Mname = n;
		menuText = m;
		choice1 = c1;
			if(c2 != null)
				choice2 = c2;
			if(c3 != null)
				choice3 = c3;
			if(c4 != null)
				choice4 = c4;
			if(c5 != null)
				choice5 = c5;
	}
	
	//returns a string of the choices
	public String getMenuName()
	{
		return Mname;
	}
	public String getMenuText()
	{
		return menuText;
	}
	
	public String getMenuChoices() {
	
		String s = "";
		if(choice1 != null)
		s += "1." + choice1;
		if(choice2 != null)
			s += " 2." + choice2;
		if(choice3 != null)
			s += " 3." + choice3;	
		if(choice4 != null)
			s += " 4." + choice4;	
		if(choice5 != null)
			s += " 5." + choice5;
		
		return s;
	}
	
	public void setChoiceFunc(String Choice, Consumer<Object[]> method)
	{
		if(Choice == "1") 
			choice1func = method;
		if(Choice == "2") 
			choice2func = method;
		if(Choice == "3") 
			choice3func = method;
		if(Choice == "4") 
			choice4func = method;
		if(Choice == "5") 
			choice5func = method;
		
	}
	// runs the choice based on the int
	//parm i: the choice the user inputes
	public void runChoice(String i, Object[] parm) {
		
		if(i.equals("1") && choice1func != null) {
			choice1func.accept(parm);
		}
		if(i.equals("2") && choice2func != null) {
			choice2func.accept(parm);
		}
		if(i.equals("3") && choice3func != null) {
			choice3func.accept(parm);
		}
		if(i.equals("4") && choice4func != null) {
			choice4func.accept(parm);
		}
		if(i.equals("5") && choice5func != null) {
			choice5func.accept(parm);
		}
		
	}
	
	public void doesShowList() {
		
		
		
		
	}

	
	
	
}