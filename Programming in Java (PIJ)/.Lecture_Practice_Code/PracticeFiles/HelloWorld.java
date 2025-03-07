
class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // PrimitiveType : byte, short, int, long, double
        // -128 to 127
        byte b = 100;

        // -32768 to 32767
        short s = 222;

        // -2147483648 to 2147483647
        int i = 333;

        // -9223372036854775808 to 9223372036854775807
        long l = 444;

        // 1.7e-308 to 1.7e+308
        float f = 555;

        // 64-bit IEEE std
        double d = 666;

        System.out.println("byte: " + b + " short: " + s + " int: " + i + " long: " + l + " float: " + f + " double: " + d);
        int xyz444 = 555;
        xyz444 = xyz444 * xyz444;
        System.out.println("xyz444: " + xyz444);
    }
}


class Progrem1 {
    public static void main(String[] args) {
        // Primitive data types byte, short, int, long, double
        byte b = 100;
        short s = 222;
        int i = 333;
        long l = 444;
        float f = 555;
        double d = 666;
        byte b1 = b + b;

    }
}

public static  int calcSum(int a, int b, int c)
{
    return (a+b+c);
}

public static void doublesumOfDoubles(double a, double b, double c) {
    return (a+b+c);
}

public static void main(String[] args) {
    int sum = calcSum(10, 20, 30);
    System.out.println("Sum of 10, 20 and 30 is: " + sum);
    double doublesum = doublesumOfDoubles(10.5, 20.5, 30.5);
    System.out.println("Sum of 10.5, 20.5 and 30.5 is: " + doublesum);

}