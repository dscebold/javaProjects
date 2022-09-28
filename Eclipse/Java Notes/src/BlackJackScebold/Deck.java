package BlackJackScebold;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	//Attributes
	private ArrayList<Card> deck;
	private Random rand;
	private String[] faceCards = {"Jack", "Queen", "King","Ace"};
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs" };
	
	//Constructor
	
	public Deck() {
		rand = new Random();
		deck = new ArrayList<>();
		makeDeck();
	}
	
	//Methods
	
	public void makeDeck() {
		for( int i = 0 ; i < this.suits.length ; i++) {
			for( int q = 2, count = 0 ; q < 15 ; q++) {
				if(q <11) {
					deck.add(new Card(q, (q + ""), this.suits[i]));
				}
				else if(q< 14) {
					deck.add(new Card(10, faceCards[count], this.suits[i]));
					count++;
				}
				else {
					deck.add(new Card(1 , faceCards[count], this.suits[i]));
				}
			}
		}
	}
	
	public void resetDeck() {
		deck.clear();
		makeDeck();
		
	}
	
	public Card deal() {
		Card draw = deck.get(rand.nextInt(deck.size()));
		deck.remove(draw);
		return draw;
	}
}
