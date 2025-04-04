public class Exception {
    public static void main(String[] args) {
        try{
            Employee e1 = new Employee(1001, 3, 50000);
            System.out.println("Employee Details" + e1.toString());
            Employee e2 = new Employee(1002, 2, 25000);
            System.out.println("Employee Details" + e2.toString());
        }
        catch(InvalidDepartmentException e){
            System.out.println(e);
        }

    }
}
