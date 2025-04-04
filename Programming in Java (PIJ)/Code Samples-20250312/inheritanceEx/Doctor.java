import java.util.GregorianCalendar;
class Doctor extends Person implements Taxable
{
	protected String qualification;
	public String specialization;
	private String license;
	public int rating;
	public boolean privatePractice;
	static int temp = 0;
	static int bloodPressure = 0;
	static double weight = 0;
	static double height = 0;

	public Doctor()
	{
		firstName = "Kelly";
		lastName = "Doe";
		setDOB(new GregorianCalendar(1999, 2, 2));
		gender = "female";
		isMarried = false;
		privatePractice = false;
		qualification = "MBBS";
		specialization = "General Practitioner";
		license = "ABCXYZ0001";
		
	}
	public Doctor(String qualification, String specialization, String license, int rating, boolean privatePractice)
	{
		this.qualification = qualification;
		this.specialization = specialization;
		this.license = license;
		this.rating = rating;
		this.privatePractice = privatePractice;
	}
	
	public String getLicense()
	{
		return license;
	}
	public void setLicense(String license)
	{
		this.license = license;
	}
	protected void writePrescription(String symptom)
	{
		if (symptom.equalsIgnoreCase("fever"))
		{
			System.out.println("Crocin is prescribed.");
		}
		else
		{
			System.out.println("No prescription.");
		}
	}
	public void suggestTests()
	{
		System.out.println("Some lab tests are suggested.");
	}
	public void exercise(int c)
	{
		System.out.println("Your calorie goal for today is: " + c);
		System.out.println("I worked for 1 hour today! I may or may not have met my calorie goal!");
	}
	public double calculateTax(double income)
	{
		if (income < 500000)
		{
			System.out.println("Your income is not taxable");
			return 0;
		}
		else
		{
			double taxAmount = (income*defaultPercent)/100;
			return taxAmount;
		}
	}
	public double calculateDeductions(double amount)
	{
		if (amount < 10000)
		{
			System.out.println("You cannot apply for tax deductions.");
			return 0;
		}
		else
		{
			System.out.println("Produce original proofs of invested amount.");
			return amount;
		}
	}
	public static void checkVitals(int t, int bp, double wt, double ht)
	{
		temp = t;
		bloodPressure = bp;
		weight = wt;
		height = ht;
		System.out.println("Your vital statistics:");
		System.out.println("Temperature:" + temp);
		if (temp > 101)
			System.out.println("Your body temperature is high. Lots of rest and fluids!");
		System.out.println("Blood Pressure:" + bloodPressure);
		if (bloodPressure > 150)
			System.out.println("Your high BP might be a result of stress.");
		
	}
	public void work()
	{
		System.out.println("No. of OPD patients attended: 100");
		System.out.println("No. of procedures: 3");
	}
}
