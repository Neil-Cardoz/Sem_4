import java.util.Scanner;

public class InsertionSimple {
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
		sc.close();
		insertionSort(numbers);
	}
	public static void insertionSort(int[] numbers)
	{
		for (int i = 1; i < numbers.length; i++) 
		{ 
			int valueToSort = numbers[i];
			int j; 
			// If we get smaller value than valueToSort then , we stop at that index. 
			for ( j = i; j > 0 && numbers[j - 1] > valueToSort; j--) {
				numbers[j] = numbers[j - 1];
			}
 
			// We will put valueToSort at that index
			numbers[j] = valueToSort;
			System.out.print("Iteration "+(i)+": ");
			printArray(numbers);
		}
		
	}
	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
