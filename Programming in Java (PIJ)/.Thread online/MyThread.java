
public class MyThread extends Thread{
    int count = 6;
    public static void main(String[] args) {
        System.out.println("Main Thread Id: " + Thread.currentThread().threadId());
        MyThread t1 = new MyThread();
        t1.setPriority(MAX_PRIORITY);
        t1.count = 300;
        System.out.println("Before it starts");
        t1.start();
        System.out.println("After it starts");
        MyThread t2 = new MyThread();
        t2.setPriority(NORM_PRIORITY);
        t2.count = 100;
        System.out.println("Before it starts");
        t2.start();
        System.out.println("After it starts");
        }
        @Override
        public void run() {
            System.out.println("Thread Id: " + this.threadId());
            System.out.println("Thread Name: " + this.getName());
            System.out.println("Thread Priority: " + this.getPriority());
            System.out.println("Calculating Fibonacci Series upto " + this.count);
            //System.out.println("Calculating Prime Number upto " + this.count);
            fibonacci(this.count);
            //checkPrime(this.count);
            
            
            
            

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
    public static void checkPrime(int n)
    {
		System.out.println("Given number:" + n);
        int iPrime = 1;
        for (int i = 2; i <= Math.sqrt(n); i++ )
        {
            if (n % i == 0)
                iPrime = 0;
        }
        
        if (iPrime == 0)
            System.out.println("The number is not prime.");
        else
            System.out.println("The number is prime.");
    }
    
}
    
   