package BlackJackScebold;
import java.util.ArrayList;

public interface GameLogicMaster {
	
	/**
	 * Used to assign a name attribute to a user defined name.
	 */
	public void setName(); 
	
	/**
	 * Similar to the live method of the pet.<br>
	 * This method contains a while loop that checks if the player still has currency. <br>
	 * Inside of the while loop this method calls all essential game logic methods in the following order.<br>
	 * <ul>
	 * 	<li>dealCards for the player and dealer</li>
	 * 	<li>print playerHand</li>
	 * 	<li>print dealerHand (not the first card)</li>
	 * 	<li>call bet() on an instance of currency</li>
	 * 	<li>call the hitStay method</li>
	 * 	<li>call the dealerTurn method</li>
	 * 	<li>call the determineWinner method</li>
	 * 	<li>call resetHand method</li>
	 * 	<li>call resetGame method</li>
	 * </ul>
	 */
	public void runGame(); 
	
	/**
	 * This Method is used to deal one card to the ArrayList<Card> passed as a parameter.<br>
	 * If the hand passed was empty it should add two cards.<br>
	 * Use ArrayList.isEmpty() and ArrayList.add( ) methods<br>
	 * Cards should come from the attribute deck using the deal() method. 
	 * @param hand An ArrayList of card objects 
	 */
	public void dealCard(ArrayList<Card> hand); 
	
	/**
	 * This method prints the card toString values for every card in the hand parameter.<br>
	 * If the firstCard parameter is true it should print the entire hand. <br>
	 * If the firstCard parameter is false it should print "Mystery Card" for the first card.<br>
	 * @param hand An ArrayList containing card objects to be printed
	 * @param firstCard A boolean to decide if the first card should be printed. 
	 */
	public void printHand(ArrayList<Card> hand, boolean firstCard);
	
	/**
	 * This method takes an ArrayList of Card objects as a parameter and returns an int representing the numeric value of all Cards.<br>
	 * The method should use the card getNumValue method to get the numeric value of each card<br>
	 * The method should initialize a boolean outside of the sum loop<br>
	 * If a card in the hand is an Ace the boolean should be set true<br>
	 * Below the sum loop if an Ace was found and the total is less than 12, ten should be added to the total<br>
	 * This allows the Ace to have a value of one or eleven depending on the hand value
	 * @param hand An ArrayList containing Card objects
	 * @return An int representing the current numeric value of the hand. 
	 */
	public int totalHand(ArrayList<Card> hand); 
	
	/**
	 * While the playerHand's numeric value is less than 21<br>
	 * <ul>
	 * 	<li>Ask the player if they want to hit or stay</li>
	 *  <li>If they hit use the dealCard method to add a card to the playerHand </li>
	 *  <li>If they stay break the loop</li>
	 * </ul>
	 */
	public void hitStay();
	
	/**
	 * While the dealHand numeric value is less than 17<br>
	 * <ul>
	 * <li>use the dealCard method to add a Card to the dealerHand</li>
	 * <li> print that the dealer drew + the toSting of the card at the index size()-1 in the dealerHand </li>
	 * </ul>
	 */
	public void dealerTurn(); 
	
	/**
	 * This method
	 * Calls printHand on both the player and dealer hands displaying all cards<br>
	 * Prints the totals for both hands<br>
	 * Decides who wins and calls currency methods<br>
	 * <ul>
	 * 		<li>check if the player and dealer have tied or both gone bust (over 21) (tie()) </li>
	 * 		<li>check if the player has gone bust (lose())</li>
	 * 		<li>Check if the dealer has gone bust or if the playerhandTotal > dealerHandTotal (win())</li>
	 * 		<li>else (lose())</li>
	 * </ul> 
	 */
	public void determineWinner(); 
	
	/**
	 * Calls the clear() method on both the playerHand and dealerHand<br>
	 * Calls resetDeck on the deck attribute
	 */
	public void resetHands();
	
	/**
	 * This method is like the resetPet method<br>
	 * If the player is out of currency (use the getCurrency() method on the currency attribute<br> 
	 * 		<ul>
	 * 			<li>ask if the player wants to play again</li>
	 * 			<li>if yes reset the currency attribute to a new instance of currency or call a method that adds currency to the currency attribute</li>
	 * 			<li>else end the game by printing a goodbye message and calling System.exit(0) </li>
	 * 		</ul>
	 */
	public void resetGame();
	
	/*
	 * #1 setName()
	 * #2 runGame()
	 * #3 dealCard(ArrayList<Card> hand) 
	 * #4 printHand(AL<Card> hand, boolean firstCard)
	 * #5 totalHand(AL<Card> hand) 
	 * #6 hitStay()
	 * #7 dealerTurn()
	 * #8 determineWinner()
	 * #9 resetHands()
	 * #10 create the currency class stuff
	 * #11 resetGame()
	 */
}
