public class InnerClassEx{

    private int outerint = 0;
    class Inner{
        void incOuterInt()
        {
            outerint++;
            System.out.println("Value of outerint inside Inner class: " + outerint);
        }
    }

    public static void main(String[] a)
    {
        InnerClassEx i1 = new InnerClassEx();
        System.out.println("Value of outerint before the method call: " + i1.outerint);
        InnerClassEx.Inner in1 = i1.new Inner();
        in1.incOuterInt();
    }
}