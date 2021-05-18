package employee;

import java.util.function.Consumer;

public interface Thirdparty extends Accounting {
	
	static Menu thrdMain = new Menu("Third Party Accounting", "", "Edit Taxes", "Edit Pension", null, null, null);
	
	public static void ThirdMainInit()
	{
		thrdMain.showList = true;
		Consumer<Object[]> ref1 = Accounting::Tax;
		thrdMain.setChoiceFunc("1", ref1);
		Consumer<Object[]> ref2 = Accounting::Pention;
		thrdMain.setChoiceFunc("2", ref2);
		
	}
	
	
	
	
	
	
}
