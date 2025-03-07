abstract class Base
{
    abstract void sayHello();

    
}
public class AnonymousInnerEx
{
    public static void main(String[] a)
    {
        Base b = new Base(){
            void sayHello()
            {
                System.out.println("Hello there!");
            }
        };
        b.sayHello();

    }

}