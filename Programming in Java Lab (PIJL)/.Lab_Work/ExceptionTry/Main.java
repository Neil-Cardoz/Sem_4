//Main.java

class Main {

    public static void checkAge(int age) throws AgeException {

        if (age < 18) {
            throw new AgeException("Age Less than 18");
        } else {
            System.out.println("Valid");
        }
    }

    public static void checkZero(int num) throws ArithmeticException{
        if (num == 0){
            throw new ArithmeticException("Zero");
        }
        else {
            System.out.println("Quotient is :" + num);
        }
    }


    public static void main(String[] args) {
        try {
            checkZero(0);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block is always executed");
        }
    }

}
