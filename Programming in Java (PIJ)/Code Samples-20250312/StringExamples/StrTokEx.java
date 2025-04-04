import java.util.StringTokenizer;

public class StrTokEx
{
    public static void main(String[] a)
    {
        String para = "The woods are lovely dark and deep; But I have promises to keep!";
        StringTokenizer st = new StringTokenizer(para, " ");
        while (st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }

        String para2 = "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.";
        StringTokenizer st2 = new StringTokenizer(para2);
        while (st2.hasMoreElements())
        {
            System.out.println(st2.nextElement());
        }
    }
}