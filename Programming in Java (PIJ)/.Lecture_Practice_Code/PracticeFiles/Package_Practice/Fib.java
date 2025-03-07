//fibonacci.java
package mypackage;
public class Fib {

    public static void fibonacci(int n) {
        int c = 0, a, b = 1;
        while (c <= n) {
            System.out.print(c + " ");
            a = b;
            b = c;
            c = a + b;
        }
        System.out.println("\n");
    }
}
// Time Complexity: O(n)
