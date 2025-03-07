// Test1 class
public class test1 {
    public static int calcSum(int a, int b, int c) {
        return (a + b + c);
    }

    public static double doubleSumOfDoubles(double a, double b, double c) {
        return (a + b + c);
    }

    public static boolean evenOdd(double a) {
        return a % 2 == 0;
    }

    public static void main(String[] args) {
        short dd = 111;
        long ll = 111;
        int ii = 111;
        System.out.println(dd + ll + ii);
        double a1 = doubleSumOfDoubles(5.2, 5.2, 5.2);
        System.out.println(calcSum(1, 2, 3));
        System.out.println(a1);
        System.out.println(evenOdd(10.2));
        System.out.println("Hello");
        System.out.println("I am at SIT");
    }
}





