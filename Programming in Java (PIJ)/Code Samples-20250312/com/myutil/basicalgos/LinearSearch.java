import java.util.*;
public class LinearSearch {
	
	public static void main(String args[])
	{
		int array[] = new int[]{28, 10, 99, 333, 78, 80, 45, 23, 93, 70};
		System.out.println("Enter the number to be searched.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int found = 0;
		sc.close();
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == num)
			{
			   found = i;
			}
		}
		if (found > 0)
		  System.out.println("Number found at index : "+ found);
		else
		  System.out.println("Number not found.");
	}

}
