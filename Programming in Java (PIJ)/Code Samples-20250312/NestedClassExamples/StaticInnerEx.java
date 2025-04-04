class StaticInnerEx
{
    private static int i;

    static class Inner
    {
        int incOuterVar()
        {
            i++;
            return i;
        }
    }

    public static void main(String[] a)
    {
        System.out.println("Value of i in the outer class: " + i);
        StaticInnerEx.Inner in1 = new StaticInnerEx.Inner();
        int r = in1.incOuterVar();
        System.out.println("Value of i after function call: " + r);
    }
}