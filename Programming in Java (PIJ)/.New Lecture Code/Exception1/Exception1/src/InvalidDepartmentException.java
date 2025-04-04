public class InvalidDepartmentException extends Exception {
    public InvalidDepartmentException( String msg ) {
        super(msg);
    }
}

class Employee {
    public int EmpID;
    public int DeptID;
    public int salary;


    public Employee(int id, int dID, double s) throws InvalidDepartmentException {
        EmpID = id;
        salary = (int) s;
        if (dID < 5)
            DeptID = dID;
        else
            throw new InvalidDepartmentException("Invalid department ID :" + dID);
    }
}