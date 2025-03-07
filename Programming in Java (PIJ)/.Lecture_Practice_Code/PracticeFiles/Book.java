// Book class
public class Book {
    public String title;
    public String author;
    public double price;
    public String ISBN;
    public String genre;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String t, double p, String i, String g) {
        title = t;
        price = p;
        ISBN = i;
        genre = g;
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title = "The greatest mental models";
        b1.price = 499;
        b1.author = "Shane Parrish";
        System.out.println("My first book details:");
        System.out.println("Title: " + b1.title);
        System.out.println("Author: " + b1.author);
        System.out.println("Price: " + b1.price);
    }
}
