// Define method1
public static void method1(SampleClass s) {
    if (s == null) {
        throw new IllegalArgumentException("SampleClass instance cannot be null");
    }
    System.out.println("Method1 executed successfully with: " + s.name);
}

public static double divideNumbers(double a, double b) {
    if (b == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }
    return a / b;
}

public static void main(String[] args) {

    try {
        // Call method1 with a null argument
        method1(null);
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid argument passed to method1: " + e);
    }

    int[] arr = new int[4];
    try {
        System.out.println("Before for loop of int array");
        for (int i = 0; i < arr.length; i++) { // Fix the loop limit
            arr[i] = i;
        }
    } catch (ArrayIndexOutOfBoundsException iob) {
        System.out.println("Array Index Out Of Bounds");
        iob.printStackTrace();
    }
    System.out.println("After try-catch of IndexOutOfBounds");
}
