
public class Employee extends Person 
{
	public int empID;
	public static String companyName;
	private double salary;
	public String designation;
	
	public Employee()
	{
		firstName = "John";
		lastName = "Smith";
		gender = "male";
		empID = 10000;
		companyName = "Acme Corp.";
		salary = 15000.99;
		designation = "Engineeer";
	}
	public Employee(String fName, String lName, String aadhar, String PAN, int id, String desig)
	{
		firstName = fName;
		lastName = lName;
		aadharNo = aadhar;
		PANNo = PAN;
		empID = id;
		designation = desig;
	}
	public Employee(int id, String cName, double s, String desig)
	{
		empID = id;
		companyName = cName;
		salary = s;
		designation = desig;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double s)
	{
		salary = s;
	}
	public void getPromoted()
	{
		designation = "Director";
		System.out.println("I got promoted.");
	}
	/*public boolean isEmployable(Date DOB)
	{
		
	}*/
	public void exercise(int c)
	{
		if (c < 500)
			System.out.println("You have not met your calorie goal today!");
		else
			System.out.println("Yay! You've burnt more than 500 calories today!");
	}
	public void changeSalary(String desig, double sal)
	{
		if (desig.equals("Software Engineer"))
		{
			if (sal < 10000)
				System.out.println("Salary is too low.You need an increment."); 
			else
				System.out.println("Salary is correct.");
		}
		else
			System.out.println("Check your designation.");
		
	}
	public void work()
	{
		System.out.println("Modules completed today: 1. Login, 2. Authentication.");
		System.out.println("Modules planned for tomorrow: 1. Payment calculation.");
	}
	
}