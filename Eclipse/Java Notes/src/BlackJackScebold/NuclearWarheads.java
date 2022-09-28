package BlackJackScebold;

import java.util.Scanner;

public class NuclearWarheads implements Chips {
	
	
	//Attributes
	/*
	 * (non-Javadoc)
	 * Object
	 * 		Scanner
	 * 
	 * int
	 * 		playerCurrency
	 * 		pot
	 * 
	 */
	
	private Scanner scan;
	private int playerCurrency, pot;
	
	//Constructor
	
	public NuclearWarheads() {
		scan = new Scanner(System.in);
		playerCurrency = 500;
		pot = 0; 
	}
	
	//Methods

	@Override
	public int getPlayerChips() {
		return this.playerCurrency;
	}

	@Override
	public void lose() {
		System.out.println("You lost loser! One step closer to MAD.");
		this.pot = 0;
		
	}

	@Override
	public void win() {
		System.out.println("You Won! Your Nuclear Arsenal Grows.");
		this .playerCurrency += this.pot;
		this.pot = 0;
		
	}

	@Override
	public void tie() {
		System.out.println("You tied and started the Cuban Missles Crisis.");
		
	}

	@Override
	public void bet() {
		while(true) {
			try {
				System.out.println("You have " + this.playerCurrency + " missles. How many missles would you like to \nplace in Cuba?");
				int bet = Integer.parseInt(scan.nextLine());
				if (bet == 0) {
					System.out.println("You actually have to send some missles to Cuba.");
				bet();
				}
				else if( bet <= this.playerCurrency && bet != 0) {
					this.playerCurrency -= bet;
					this.pot += (2 * bet);
					System.out.println("You have added " + bet + " missles to Cuba. There are now " + this.pot + " \nmissles in Cuba.");
				}
				else if(bet > this.playerCurrency) {
					System.out.println("You have insufficient missles, send less missles to Cuba.");
					bet();
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("You must type a number.");
			}

		}
		
		
	}

	public void addNukes() {
		this.playerCurrency += 100;
		
	}
	
	public void newNukes() {
		this.playerCurrency = 500;
		this.pot = 0;
	}

}
