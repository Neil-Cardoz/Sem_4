//package inheritanceEx;
public class MainForPersonEmpDoctor
{
    public static void main(String[] args) {
        Employee e1 = new Employee();
        System.out.println("Employee e1 details:");
        System.out.println("First Name:" + e1.firstName);
        System.out.println("Last Name:" + e1.lastName);
        System.out.println("Gender:" + e1.gender);

        Employee e2 = new Employee("Suzie", "Lehman","123456789012", "STUVE090RF", 45001, "Director");
        e2.setSalary(45000);
        e2.exercise(350);
        e2.work();
        e2.changeMaritalStatus(true);
        e2.changeSalary("Director", 45000);

        printEmpDetails(e2);
        e2.sleep(10);

        Doctor d1 = new Doctor();
        printDoctorDetails(d1);
        d1.exercise(400);
        d1.work();
        double taxAmt = d1.calculateTax(5000000);
        System.out.println("Your tax amount for this financial year is:" + taxAmt);
        d1.sleep(6);

    }
    public static void printEmpDetails(Employee e)
	{
        System.out.println("Employee Details:");
        System.out.println("First Name: " + e.firstName);
        System.out.println("Last Name: " + e.lastName);
        System.out.println("Gender: "+e.gender);
        System.out.println("Aadhar no. : " + e.aadharNo);
        System.out.println("PAN No. : " + e.PANNo);
        System.out.println("Date of birth: " + e.getDOB());
        System.out.println("Marital status: " + e.isMarried);
        System.out.println("Employee ID: " + e.empID);
        System.out.println("Company Name: " + Employee.companyName);
        System.out.println("Designation: " + e.designation);
		System.out.println("Salary: " + e.getSalary());

	}
    public static void printDoctorDetails(Doctor d)
    {
        System.out.println("Doctor details:");
        System.out.println("First Name: " + d.firstName);
        System.out.println("Last Name: " + d.lastName);
        System.out.println("Gender: "+d.gender);
        System.out.println("Aadhar no. : " + d.aadharNo);
        System.out.println("PAN No. : " + d.PANNo);
        System.out.println("Date of birth: " + d.getDOB());
        System.out.println("Marital status: " + d.isMarried);
        System.out.println("Qualification: " + d.qualification);
        System.out.println("Specialization: " + d.specialization);
        System.out.println("License no. : " + d.getLicense());
        System.out.println("Rating: " + d.rating);
        System.out.println("Private practice? :" + d.privatePractice);
    }
}