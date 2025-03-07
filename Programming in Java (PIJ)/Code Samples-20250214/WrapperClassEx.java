import java.util.ArrayList;
public class WrapperClassEx
{
    public static void main(String[] a)
    {
        Integer i1 = 250;
        Byte b1 = 22;

        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(i1);
        al1.add(300);
        al1.add(new Integer(450));
        System.out.println("Size of integer ArrayList: " + al1.size());
        int i2 = Integer.parseInt("500");
        al1.add(1, i2);
        System.out.println("Members of ArrayList: ");
        for (Integer e : al1)
        {
            System.out.println(e);
        }
    }
    
}