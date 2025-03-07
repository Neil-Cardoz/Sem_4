import java.util.*;

public class WrapperClassEx {

    public static void main(String[] a) {

        Integer i1 = 250;
        byte b1 = 127;
        char c1 = 'a';
        Character c = 'A'; // Fixed character assignment

        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(i1);
        al1.add(b1);
        al1.add(450);
        System.out.println("Size of integer ArrayList : " + al1.size()); // Fixed print statement

        // Sorting ArrayList
        al1.sort(null);
        System.out.println("Members of ArrayList after Sorting :");
        for (Integer e : al1) {
            System.out.println(e);
        }

        // String ArrayList Example
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("Sun");
        lst.add("Mon");
        System.out.println("String ArrayList Elements :");
        for (String day : lst) {
            System.out.println(day);
        }

        // Character ArrayList
        ArrayList<Character> cc = new ArrayList<Character>();
        cc.add('A'); // Fixed character literal
        for (char c2 = 'B'; c2 < 'F'; c2++) {
            cc.add(c2);
        }
        System.out.println("Character ArrayList Elements :");
        for (Character c3 : cc) {
            System.out.println(c3);
        }
    }
}
