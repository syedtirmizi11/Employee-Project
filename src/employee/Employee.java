package employee;

class incidentReport{
	String name = "";//must have unique name
	String date = "";//when it happened
	String notes = ""; //the description of the event
	incidentReport(String n, String d, String no){
		name = n;
		date = d;
		notes = no;
	}
	
}



public class Employee {
	private String fname;
	private String lname;
	private String id;
	private String role = "none";

	private double salary = 0.0;
	private double tax = 0.0;
	private double pention = 0.0;
	private String medplan = "None";
	private int vacationDays = 0;
	private int incidentCount = 0;


	private incidentReport[] incidentReports = new incidentReport[10];
	
	
	public Employee(String fn, String ln, String Id, double pay) {
		fname = fn;
		lname = ln;
		id = Id;
		salary = pay;
		
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public String getBenifites() {
		return medplan;
	}


	public void setBenifites(String benifites) {
		this.medplan = benifites;
	}


	public int getVacationDays() {
		return vacationDays;
	}


	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public String getAllIncidentReports() {
		String s = "";
		for(int i=0;i<incidentCount;i++)
		s += incidentReports[i].name + "\n" + incidentReports[i].date + "\n" + incidentReports[i].notes;
		return s;
	}
	
	
	public String[] getIncidentReport(String name) {
		String report[] = new String[2];
		for(int i=0;i<incidentReports.length;i++)
		{
			if(name.equals(incidentReports[i].name))
			{
				report[0] = incidentReports[i].name;
				report[1] = incidentReports[i].date;
				report[2] = incidentReports[i].notes;
			}
				
		}	
		
		return report;
	}


	public void addIncidentReports(String n, String d, String note) {
		int index = incidentCount;
		if(incidentCount >= 10)
		{
			View.print("This employee has the maximum amount of incident reports");
			return;
		}
		incidentReports[index] = new incidentReport(n,d,note);
		
		this.incidentReports[index].name = n;
		this.incidentReports[index].date = d;
		this.incidentReports[index].notes = note;
		this.incidentCount++;
	}
	public void removeIncidentReport(String name)
	{
		for(int i=0;i<incidentReports.length;i++)
		{
			if(name.equals(incidentReports[i].name))
			{
				incidentReports[i].name = "";
				incidentReports[i].date = "";
				incidentReports[i].notes = "";
				incidentCount--;
			}
				
		}	

	}
	
	public int getIncidentCount() {
		return incidentCount;
	}

	
	public incidentReport[] getIncidentReports() {
		return incidentReports;
	}


	public void setIncidentReports(incidentReport[] incidentReports) {
		this.incidentReports = incidentReports;
	}
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	public Double getPention() {
		return pention;
	}


	public void setPention(Double p) {
		this.pention = p;
	}
	
	
	
}

