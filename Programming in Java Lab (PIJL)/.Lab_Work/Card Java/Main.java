//Main.java


public class Main{
	public static void main(String args[]){
		Deck deck = new Deck();
		System.out.println("----------Creating Deck-----------");
		deck.createDeck();
		System.out.println("----------Displaying Deck-----------");
		deck.displayDeck();
		System.out.println("----------Shuffling Deck-----------");
		deck.shuffleDeck();
		System.out.println("----------Displaying Deck-----------");
		deck.displayDeck();
		System.out.println("----------Displaying 2 Random Cards-----------");
		deck.randomCards();
		System.out.println("----------Displaying 2 Random Cards to 5 players-----------");
		deck.cardPlayers();
	}
}