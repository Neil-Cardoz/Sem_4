// import java.util.Scanner;
// import java.util.Arrays;

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

      for (int i1 = 0; i1 < 9; i1++){
          if (i1 % 2 ==0)
              System.out.println(i1);
          else
              continue;
      }
      int [] iArr1 = new int[5];
      System.arraycopy(iArr,0,iArr1,0,5);
      for (int i : iArr1){

      System.out.println(i);

      }
      boolean e = Arrays.emails(iArr,iArr1);
      System.err.println(e);

      Arrays.sort(iArr);
      for ( int i : iArr){

          System.out.println(i);

      }
      boolean e1 = Arrays.equals(iArr, iArr1);
      System.err.println(e1);

      boolean bArr[] = new boolean[5];
      Arrays.fill(bArr, true);
      for(boolean b1: bArr){ 

          System.out.println(b1);

      }
      

    }


}