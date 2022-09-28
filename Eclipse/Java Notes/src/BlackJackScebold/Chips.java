package BlackJackScebold;

public interface Chips {
	
	
	/**
	 * Tells you how much currency you have
	 * @return The number of remaining currency
	 */
	public int getPlayerChips();
	
	/**
	 * sets the pot attribute to zero
	 * prints you lose
	 */
	public void lose();
	
	/**
	 * add the pot attribute to the playerCurrency attribute
	 * set the pot attribute to zero
	 * print you win
	 */
	public void win();
	
	/**
	 * print you tied
	 */
	public void tie();
	
	/**
	 * Bet asks the player how much they want to wager.
	 * This method should ask the Scanner attribute.
	 * This method should be protected against errors using a try catch 
	 * This method should make sure the bet is valid.
	 * if gthe bet is valid, subtract the bet from the playerCurrency attribute
	 * and set the pot += the bet times two
	 */
	public void bet();

}
