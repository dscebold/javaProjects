package BlackJackScebold;

public class Card {
	
	
	//Attributes
	private int numValue;
	private String suit, value;
	
	//Constructor
	
	public Card(int num, String val, String theSuit) {
		this.numValue = num;
		this.value = val;
		this.suit = theSuit;
	}
	
	//Methods

	public int getNumValue() {
		return numValue;
	}

	public String getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}
	
	public String toString() {
		return this.value + " of " + this.suit;
		
	}
}
