package com.myutil.basicalgos;

public class Fib {
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
	public static void evens(int n)
	{
		
		for (int i = 1; i <= n; i++)
		{
			if (i%2 == 0)
				System.out.println(i);
		}
	}

}
