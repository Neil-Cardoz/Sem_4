public class StringConsAndMethods
{
    public static void main(String[] a)
    {
        String s1 = "First string object";
        String s2 = "Second string object";
        String s3 = s1 + " " + s2;
        System.out.println(s3);
        char[] c1 = new char[] { 't', 'h', 'i', 'r', 'd' };
        String s4 = new String(c1);
        System.out.println(s4);

        String s5 = new String(c1, 1, 3);

        System.out.println(s5);
        //concat method
        String s6 = s1.concat(s2);
        System.out.println("Concat output: " + s6);
        String[] words = s1.split(" ", 3);
        System.out.println("Split words: ");
        for(String word: words)
        {
            System.out.println(word);
        }
        //Create 2 objects of Sample class
        Sample sm1 = new Sample();
        sm1.i = 5;
        sm1.d = 22.33;

        Sample sm2 = new Sample();
        sm2.i = 10;
        sm2.d = 12.33;

        //Concatenate the objects.
        String objStr = (sm1.toString()).concat(sm2.toString());
        System.out.println("Object as a String combined : " + objStr);

        //Print the members of the objects as combined string.
        System.out.println("Integer members of objects combined : " + sm1.i + " " + sm2.i);
        System.out.println("Double members of objects combined : " + sm1.d + " " + sm2.d);

        String strWithSlash = "c:\\test\\newDir";
        System.out.println("Escape sequence example: String with \\ : " + strWithSlash);

        String strWithQuotes = "The teacher said, \"The more you code, the better for you!\" ";
        System.out.println("Escape sequence example: String with \" :" + strWithQuotes);

        //You can also use \t and \n
        System.out.println("Escape squence \\t used in string: " + "The table has Name \t Age");
        System.out.println("Escape sequence \\n used for new line." + "First Name\n" + "Last Name");

        //Operator overloading examples.
        String hs1 = "hello everyone!";
        String hs2 = "Hello";
        System.out.println("+ operator result:" + (hs1 + hs2));

        //Let's see which other operators are overloaded.
        System.out.println("Comparison using != operator:" + (hs1 != hs2));
        System.out.println("Comparison using == operator:" + (hs1 == hs2));

         //Operations: StartsWith and EndsWith
         s1 = "First string object.";
         boolean b1 = s1.startsWith("F");
         boolean b2 = s1.endsWith("g");
         System.out.println("Results of StartsWith and EndsWith methods: " + b1 + " " + b2);
 
         //Operations: ToUpper and ToLower
         String s13 = "Never write everything in upper case!";
         String s14 = s13.toUpperCase();
         System.out.println("Result of ToUpper method:" + s14);
 
         String s15 = "Everything in lower case also looks BAD!";
         String s16 = s15.toLowerCase();
         System.out.println("Result of ToLower method:" + s16);

    }
}
class Sample
{
    public int i;
    public double d;
}