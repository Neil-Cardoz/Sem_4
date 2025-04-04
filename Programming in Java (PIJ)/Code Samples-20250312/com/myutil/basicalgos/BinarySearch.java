import java.util.Scanner;

public class BinarySearch {
	int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
  
    // Driver method to test above 
    /*public static void main(String args[]) 
    { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length; 
        int x = 10; 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } 
    
  public static void main(String args[])
  {
	  int sortedArr[] = new int[] {12, 29, 44, 52, 61, 68, 79, 88, 90, 99};
	  System.out.println("Enter the number to be searched:");
	  Scanner sc = new Scanner(System.in);
	  int num = sc.nextInt();
	  
	  int left = 0, right = sortedArr.length - 1;
	  int found = 0;
	  while (left <= right)
	  {
		  int m = (left + right)/2;
		  if (left > right)
		  {
			  System.out.println("Element not found");
			  return;
		  }
		  if (sortedArr[m] < num)
		  {
			  right = m - 1;
		  }
		  else if (num > sortedArr[m])
		  {
			  left = m + 1;
		  }
		  else
		  {
			  found = m;
		  }
		  return;    
	  }
	  
	  System.out.println("Number found at: " + found);
	  
	  
  }*/
}
