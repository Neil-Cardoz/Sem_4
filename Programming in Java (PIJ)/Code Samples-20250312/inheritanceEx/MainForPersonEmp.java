//package inheritanceEx;
public class MainForPersonEmp
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
}