package BlackJackScebold;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic implements GameLogicMaster {

	// Attributes
	private Scanner scan;
	private Deck deck;
	private NuclearWarheads nukes;
	private ArrayList<Card> playerHand, dealerHand;
	private String name;
	private Boolean communist;
	/*
	 * Objects Deck Scanner Currency 2 ArrayList<Card> playerHand dealerHand String
	 * name
	 * 
	 */

	// Constructor

	public GameLogic() {
		scan = new Scanner(System.in);
		deck = new Deck();
		nukes = new NuclearWarheads();
		playerHand = new ArrayList<>();
		dealerHand = new ArrayList<>();
		name = new String();
		communist = false;

	}

	// Methods
	
	@Override
	public void setName() {
		System.out.println("What is your name, new member to the Nuclear Club?");
		String names = scan.nextLine();
		this.name = names;
		System.out.println("Time to start a new gambling addiction " + this.name + ".");
	}

	@Override
	public void runGame() {
		setName();
		while (this.nukes.getPlayerChips() >= 0) {
			hitStay();
		}
	}

	@Override
	public void dealCard(ArrayList<Card> hand) {
		if (hand.isEmpty()) {
			hand.add(this.deck.deal());
			hand.add(this.deck.deal());
		} else {
			hand.add(this.deck.deal());
		}
	}

	@Override
	public void printHand(ArrayList<Card> hand, boolean firstCard) {
		for (Card cards : hand) {
			if (firstCard == true) {
				System.out.println(cards.toString());
			} else {
				firstCard = true;
				System.out.println("Mystery Card");
			}
		}
	}

	@Override
	public int totalHand(ArrayList<Card> hand) {
		int total = 0;
		boolean ace = false;
		for (Card cards : hand) {
			total += cards.getNumValue();
			if (cards.getValue().contentEquals("Ace")) {
				ace = true;
			}
		}
		if (ace == true && total < 12) {
			total += 10;
		}
		return total;
	}

	@Override
	public void hitStay() {
		if (totalHand(playerHand) < 21) {
			if (this.playerHand.isEmpty()) {
				this.nukes.bet();
				dealCard(playerHand);
			}
			System.out.println("Player Hand: ");
			printHand(playerHand, true);
			System.out.println("Do you want another Card?\n1.Yes\n2.No");
			String hit = scan.nextLine();
			if (hit.equalsIgnoreCase("Yes") || hit.contains("1")) {
				dealCard(playerHand);
			} else if (hit.equalsIgnoreCase("No") || hit.contains("2")) {
				System.out.println(
						"You have chosen not to take a card. The dealer will now take his \nturn and then the winner will be revealed.");
				dealerTurn();
			}

		} else if (totalHand(playerHand) > 21) {
			System.out.println("Player Hand: ");
			printHand(playerHand, true);
			System.out.println("You have gone bust.");
			dealerTurn();
		} else if (totalHand(playerHand) == 21) {
			System.out.println("Player Hand: ");
			printHand(playerHand, true);
			System.out.println("You have 21 and cannot draw anymore cards without going bust");
			dealerTurn();
		}
	}

	@Override
	public void dealerTurn() {
		dealCard(dealerHand);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("\nDealer Hand: ");
		printHand(dealerHand, false);
		while(totalHand(dealerHand) < 17) {
			dealCard(dealerHand);
			System.out.println("The dealer drew a " + this.dealerHand.get(this.dealerHand.size() - 1));
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printHand(dealerHand, false);
		}
		determineWinner();
	}

	@Override
	public void determineWinner() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nYour Hand: ");
		printHand(playerHand, true);
		System.out.println("\nDealer Hand: ");
		printHand(dealerHand, true);
		if ((totalHand(dealerHand) > 21 && totalHand(playerHand) > 21)
				|| (totalHand(dealerHand) == totalHand(playerHand))) {
			this.nukes.tie();
		} else if ((totalHand(dealerHand) > totalHand(playerHand) && (totalHand(dealerHand) <= 21)) || totalHand(playerHand) > 21) {
			this.nukes.lose();
		} else if ((totalHand(dealerHand) < totalHand(playerHand) && (totalHand(playerHand) <= 21))  || totalHand(dealerHand) > 21) {
			this.nukes.win();
		} else {
			this.nukes.lose();
		}
		resetHands();
		if(this.nukes.getPlayerChips() == 0) {
			resetGame();
		}
	}

	@Override
	public void resetHands() {
		this.playerHand.clear();
		this.dealerHand.clear();
		this.deck.resetDeck();

	}

	@Override
	public void resetGame() {
		if (nukes.getPlayerChips() == 0 && this.communist == false) {
			System.out.println(
					"You have wasted all of your nukes, A big, tall man with golden eyes steps out of the shadows. \nHe offers you 100 nukes in exchange for letting \ncommunism into your country. Do you accept?\n1.Yes\n2.No");
			String communist = scan.nextLine();
			if (communist.equalsIgnoreCase("Yes") || communist.contains("1")) {
				System.out.println("Stalin has introduced communism into your country in exchange for 100 nukes");
				this.nukes.addNukes();
				this.communist = true;
			} else if (communist.equalsIgnoreCase("No") || communist.contains("2")) {
				System.out.println(
						"You have rejected communism and run out of nukes, would you like to try again?\n1.Yes\n2.No");
				String newGame = scan.nextLine();
				if (newGame.equalsIgnoreCase("Yes") || newGame.contains("1")) {
					this.nukes.newNukes();
					System.out.println("The addictive cycle continues.");
					runGame();
				} else if (newGame.equalsIgnoreCase("No") || newGame.contains("2")) {
					System.out.println("Your gambling addiction is now over, as is this game.");
					System.exit(0);
				}
			}
		} else if (this.communist == true) {
			System.out.println(
					"Soviet Russia has taken over your government. You are now a puppet \nleader with no power. Enjoy your remaining time \nuntil you eventual KGB assasination");
			System.out.println("Do you want to play again?\n1.Yes\n2.No");
			String newGame = scan.nextLine();
			if (newGame.equalsIgnoreCase("Yes") || newGame.contains("1")) {
				this.nukes.newNukes();
				System.out.println("The addictive cycle continues.");
				this.communist = false;
				runGame();
			} else if (newGame.equalsIgnoreCase("No") || newGame.contains("2")) {
				System.out.println("Your gambling addiction is now over, as is this game.");
				System.exit(0);
			}
		}
	}

}
