//Deck.java

import java.util.*;

class Deck {
	ArrayList<Card> deck;
	
	public Deck(){
		deck = new ArrayList<>();	
	}
	
	public void createDeck(){
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
		for (String rank: ranks){
			for(String suit: suits){
				deck.add(new Card(rank,suit));
			}
		}
						
	}
	
	void displayDeck() {
		for(Card card : deck) {
			System.out.println(card);
		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
// Print 2 randomcards from the deck
	public void randomCards(){
		Collections.shuffle(deck);
		System.out.println("The 2 cards are "+deck.get(1)+" , "+deck.get(2));
	}
	

//Create 3 players and distribute 5 cards at random to players and display cards of all players
	public void cardPlayers() {
    Collections.shuffle(deck);  // Shuffle the deck once before distribution

    int cardIndex = 0;  // To keep track of cards being dealt

    for (int i = 1; i <= 3; i++) { // Loop for 2 players
        System.out.println("Player " + i + " gets the following cards:");
        for (int j = 1; j <= 5; j++) { // Each player gets 2 cards
            System.out.println("- " + deck.get(cardIndex)); 
            cardIndex++; // Move to the next card
        }
        System.out.println(); // Adding space for better readability
    }
}


}