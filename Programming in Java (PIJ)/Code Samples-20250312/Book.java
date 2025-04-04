//import java.util.ArrayList;
//import java.util.LinkedList;

public class Book
{
	public String title;
	public double price;
	public String ISBN;
	public String genre;
	public String author;
	
	public Book()
	{

	} 
	public Book(String t, double p)
	{
		title = t;
		price = p;

	}
	public Book(String t, double p, String i, String g)
	{
		title = t;
		price = p;
		ISBN = i;
		genre = g;
	}

	public static void main(String[] args)
    {
      /* Book b1 = new Book();
	  b1.title = "The great mental models";
	  b1.price = 499;
	  b1.author = "Shane Parrish";
	  System.out.println("My first book details:");
	  System.out.println("Title: " + b1.title);
	  System.out.println("Price: " + b1.price);
	  System.out.println("Author: " + b1.author); */

	  Book b2 = new Book("Outlive", 230);
	  System.out.println("Book object with 2 data members: ");
	  System.out.println(b2.title);
	  System.out.println(b2.price);

	  Book b3 = new Book("The anthalogy of Balaji", 444.25, "IST0004", "non fiction");
	  System.out.println("Book object with 4 data members: ");
	  System.out.println(b3.title);
	  System.out.println(b3.price);
	  System.out.println(b3.ISBN);
	  System.out.println(b3.genre);
    }
	
}
