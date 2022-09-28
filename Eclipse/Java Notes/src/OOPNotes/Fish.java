package OOPNotes;

import java.util.Random;
import java.util.Scanner;

public class Fish {
	
	//Attributes
	private String name;
	private Scanner scan;
	private Random rand;
	private int clean, life, hunger;
	private boolean alive;
	private String[] actions = {"swims", "bubbles", "plots global domination", "poops", "attempts to transend reality", "kills GOD", "hates you with every fiber of its being" };//, "Summon Paladin"}; 
	
	//Constructors
	public Fish() {
		rand = new Random();
		scan = new Scanner(System.in);
		setUp();
		
	}
	
	//Methods
	
	private void setUp() {
		name = setName();
		alive = true;
		clean = 10;
		life = rand.nextInt(11) + 2;
		hunger = rand.nextInt(51) + 50;
	}

	private String setName() {
		System.out.println("What would you like to call you new little fishy wishy");
		String aName = scan.nextLine();
		System.out.println("Your fish is now named " + aName + " and it hates that name... and you.");
		return aName;
	}

	public void setClean() {
		this.clean = rand.nextInt(2) + 1;
	}

	public void setLife() {
		if(this.life <= 2) {
			this.life -= 1;
			System.out.println("The tank is toxic.");
		}
		if(this.hunger <=20) {
			this.life -= 1;
			System.out.println(this.name + " is starving and may actually hate you more.");
		}
		this.life -= 1;
		setHunger();
		setClean();
		setAlive();
	}

	public void setHunger() {
		this.hunger -= rand.nextInt(11) + 5;
	}

	public void setAlive() {
		if(this.life <= 0 && this.alive) {
			System.out.println(this.name + " is floating at the top of the tank and needs to be flushed");
			this.alive = false;
		}
	}
	
	public void fishLife() {
		while(this.alive) {
			System.out.println(toString());
			String command = getCommand();
			doCommand(command);
			String fishAction = this.actions[rand.nextInt(this.actions.length)];
			if(fishAction.equals("poops")) {
				this.clean--;
			}
			//else if(fishAction.equals("Summon Paladin")) {
				// Paladin fishPaladin = new Paladin(false);
				//
			//}
			System.out.println(this.name + " " + fishAction + ".");
			setLife();
			newFish();
		}
		System.out.println("Probably a wise choice. That fish always looked at you funny anyway.");
	}
	
	private void newFish() {
		if(this.alive == false) {
			System.out.println("Would you like a new fish?");
			if(scan.nextLine().toLowerCase().contains("yes")) {
				setUp();
			}
			
		}
		
	}

	private void doCommand(String command) {
		if(command.contains("feed")) {
			feedFish();
		}
		else if(command.contains("clean")) {
			cleanTank();
		}
		else if(command.contains("nothing")) {
			somethingElse();
		}
		else {
			System.out.println("OK... not a choice but... ok.");
		}
			
	}
	
	private void somethingElse() {
		if(rand.nextInt(5) == 1) {
			System.out.println("While being left alone " + this.name + " discovered a key fact abut the universe.");
			this.life += 10;
		}
		
	}
	
	public  String toString() {
		String output = this.name;
		output += "\n\tClean: " + this.clean;
		output += "\n\tHunger: " + this.hunger;
		output += "\n\tLife: " + this.life + "\n";
		return output;
				
	}

	private void cleanTank() {
		System.out.println("You cleaned " + this.name + "'s tank.");
		System.out.println("This is the one thing you can do that makes " + this.name + " hate you a little less.");
		this.clean = 10;
		
	}

	private void feedFish() {
		System.out.println("You fed " + this.name + " the same flake you always do.");
		System.out.println("This contributes to " + this.name + "'s long standing hatred of you.");
		this.hunger += rand.nextInt(102-this.hunger);
		this.clean--;
		
	}

	private String getCommand() {
		System.out.println("What would you like to do? [\"clean\", \"feed\", \"nothing\"]");
		return scan.nextLine().toLowerCase();
		
	}
	

}
