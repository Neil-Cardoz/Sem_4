import com.myutil.basicalgos.*;

class MainForPackage
{
    public static void main(String[] a)
    {
        Fib.fibonacci(5);
        Fib.evens(10);
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
}