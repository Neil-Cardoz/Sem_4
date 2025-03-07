import java.util.GregorianCalendar;

class Employee extends Person
{
    public int empID;
    public static String companyName;
    private double salary;
    public String designation;

    public Employee()
    {
        firstName = "John";
        lastName = "Wick";
        gender = "male";
        empID = 10000;
        companyName = "Acme Corp.";
        salary = 15000.99;
        designation = "Engineer";
    }

    public Employee( String fName, String lName, String aadhar, String PAN, int id, String desig){
        firstName = fName;
        lastName = lName;
        aadharNo = aadhar;
        PANno = PAN;
        empID = id;
        designation = desig;
    }

    public void setSalary(double s){
        salary = s;
    }

    public double getsalary(){
        return salary;
    }

    public void exercise(int c){
        if ( desig.equals ("Software Engineer")){

            if(sal < 10000)
                System.out.println("Salary too low, you need an increment");
            else
                System.out.println("Salary is correct");
        }
        else
            System.out.println("Check your Designation");
    }

    public void work(){
        System.out.println("Modules completed today: 1.Login, 2.Authentication");
        System.out.println("Modules planned for tommorrow 1.Payment calculation");
    }



}