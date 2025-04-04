public class BasicDataTypes {

	
	public static void main(String[] args)
	{
		//byte range : -128 to 127
		byte b1 = 125;
		byte b2 = -100;
		
		System.out.println(b1+b2);
		System.out.println ("b1 value:"+ b1);
		System.out.println("b2 value:" + b2);
		
		//short range : -32768 to 32767
		short sh1 = 255;
		short sh2 = 10;
		System.out.println (sh1*sh2);
		
		//int range: -2**31 to 2**31 - 1
		int int1 = 999999999;
		
		int iBase = 32;
		int iPow = 2;
		System.out.println(Math.pow(iBase, iPow));
		
		//long range: -2**63 to 2**63 - 1
		long l1 = 88888L;
		float f1 = 66666.4444F;
		double d1 = 99999933333.99999;
		
		System.out.println(l1/f1);
		System.out.println(d1/l1);
		System.out.println(l1+f1+d1);
		
		char c1 = 'p';
		boolean bool1 = true;
		String s1 = "anything";
	  
		System.out.println (int1);
		
		
		System.out.println("Value of long type variable:"+l1);
		
		/*boolean bb1;
		System.out.println (bb1);
		long ll1;
		System.out.println(ll1);*/
		
	}
}
