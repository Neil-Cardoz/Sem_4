import java.util.Scanner;

public class MyRunnable implements Runnable {
    static Scanner sc = new Scanner(System.in);
    int count = 6;
    @Override
    public void run() {
        // To do auto-generated method stub
        System.out.println("My Runnable Thread is running");
        System.out.println("Thread Id: " + Thread.currentThread().threadId());
        System.out.println("Enter a number toprint the fibonacci series upto that number");
        int n = sc.nextInt();
        fibonacci(n);

     
    }
    public static void fibonacci(int n)
	{
		int c=0, a=0, b=1;
		while(c<=n)
		{
		       System.out.print(c+" ");
		       a=b;
		       b=c;
		       c=a+b;
		}
        System.out.println("\n");
    }
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        System.out.println(t.isAlive());
    }
    
}
