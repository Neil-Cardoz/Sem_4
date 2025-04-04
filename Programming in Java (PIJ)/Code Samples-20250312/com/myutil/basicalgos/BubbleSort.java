package com.myutil.basicalgos;
import java.util.*;

public class BubbleSort {
	
	public static void swap(int[] array, int from, int to)
	{
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}
	
	public static void bubbleSort(int[] numbers)
	{
		System.out.printf("Unsorted array in Java :%s %n", Arrays.toString(numbers)); 
		for (int i = 0; i < numbers.length; i++) 
		{ 
			for (int j = numbers.length -1; j > i; j--) 
			{ 
				if (numbers[j] < numbers[j - 1]) 
		
				{ 
					swap(numbers, j, j-1); 
				} 
			} 
	    } 
	    System.out.printf("Sorted Array using Bubble sort algorithm :%s %n", Arrays.toString(numbers));

	}
	
	public static void main(String args[])
	{
		System.out.println("Enter number of elements in array.");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int numbers[] = new int[count];
		System.out.println("Enter elements of the array:");
		for (int i = 0; i < count; i++)
		{
			numbers[i] = sc.nextInt();
		}
		bubbleSort(numbers);
	}


}


