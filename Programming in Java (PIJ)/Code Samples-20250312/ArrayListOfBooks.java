import java.util.ArrayList;
public class ArrayListOfBooks
{
    public static void main(String[] args) {
        Book b1 = new Book("Icon", 499, "FIC000111", "Fiction");
        ArrayList<Book> alb = new ArrayList<>();
        alb.add(b1);
        Book b2 = new Book("21 lessons for the 21st century", 655);
        alb.add(b2);
        System.out.println("Book details from the ArrayList:");
        for (Book b : alb)
        {
            System.out.println("Title:" + b.title);
            System.out.println("Price:" + b.price);
            System.out.println("ISBN:" + b.ISBN);
            System.out.println("Genre:" + b.genre);
        }
        System.out.println("Is array list empty? " + alb.isEmpty());
        System.out.println("Size of array list: " + alb.size());
        Book b3 = new Book("Outlive", 370, "LIF34567", "non-fiction");
        Book b4 = new Book("My experiments with truth", 549, "AUT0342198", "Autobiography");
        ArrayList<Book> alb2 = new ArrayList<>();
        alb2.add(b3);
        alb2.add(b4);
        alb.addAll(alb2);
        System.out.println("Book details from the ArrayList after adding b3 and b4:");
        for (Book b : alb)
        {
            System.out.println("Title:" + b.title);
            System.out.println("Price:" + b.price);
            System.out.println("ISBN:" + b.ISBN);
            System.out.println("Genre:" + b.genre);
        }
        
        
    }
}