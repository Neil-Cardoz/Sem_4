import java.util.Scanner;
import java.util.Arrays;
public class ArrayEx {
	public static void main(String[] x)
	{
		int[] iArr;
		iArr = new int[5];
		iArr[0] = 20;
		iArr[1] = 40;
		iArr[2] = 100;
		iArr[3] = 32;
		iArr[4] = 22;
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println(iArr[i]);
		}
		
		for (int i1 = 0; i1 < 9; i1++)
		{
			if (i1 % 2 == 0)
				System.out.println(i1);
			else
				continue;
		}
		
		int[] iArr1 = new int[5];
		System.arraycopy(iArr, 0, iArr1, 0, 5);
		
		for(int i : iArr1)
		{
			System.out.println(i);
		}
		boolean e = Arrays.equals(iArr, iArr1);
		System.out.println(e);
		
		Arrays.sort(iArr);
		for(int i : iArr)
		{
			System.out.println(i);
		}
		boolean e1 = Arrays.equals(iArr, iArr1);
		System.out.println(e1);
		
		boolean bArr[] = new boolean[5];
		
		Arrays.fill(bArr, true);
		for (boolean b1 : bArr)
		{
			System.out.println(b1);
		}
		
		double d1[] = new double[3];
		Arrays.fill(d1, 111.11);
		
		
		
		double[] dArr = new double[] {100.22, 44.33, 55, 89.09, 67.55};
		
		for(double d : dArr)
		{
			double halfD = d/2;
			System.out.println(halfD);
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a day of the week: ");
		String s = scan.nextLine();
		//int n = scan.nextInt();
		//System.out.println("Hello, " + name);
		
		String[] sArr = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		
		for (String day : sArr)
		{
			if (s.equals(day))
			{
				System.out.println("You have entered correct day of the week!");
				break;
			}
			else
			{
				//System.out.println("Garbage value.");
				continue;
			}
		}		
		
		switch(s)
		{
			case "Mon":
				System.out.println("First day of the week!");
				break;
			case "Tue":
				System.out.println("Second day of the week!");
				break;
			case "Wed":
				System.out.println("Third day of the week!");
				break;
			case "Thu":
				System.out.println("Fourth day of the week!");
				break;
			case "Fri":
				System.out.println("Fifth day of the week!");
				break;
			case "Sat":
				System.out.println("Weekend started!");
				break;
			case "Sun":
				System.out.println("Another week starts !");
				break;
			default:
				System.out.println("Incorrect day of the week!");
				break;
		}
		
		scan.close();
		
	}

}
