 class LocalInnerEx
{
    void displayMessage(String name)
    {
        class Inner{
            void sayHello()
            {
                System.out.println("Hello there, " + name);
            }
        }
        Inner in1 = new Inner();
        in1.sayHello();
    }

    public static void main(String[] a)
    {
        LocalInnerEx l1 = new LocalInnerEx();
        l1.displayMessage("Pratima");
    }
}