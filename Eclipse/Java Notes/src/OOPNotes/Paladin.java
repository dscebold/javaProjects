package OOPNotes;

import java.util.Random;
import java.util.Scanner;

public class Paladin {
	
	//Attributes
	private String name;
	private Random rand;
	private Scanner scan;
	private Diety myDiety;
	private int health, power; //you can double declare attributes if they are the same data type
	private boolean bot, alive;
	private String[] actions = {"heal", "power up", "summon diety", "attack", "nothing","ritual sudoku"};
	
	//Constructor
		public Paladin(boolean auto) {
			rand = new Random();
			scan = new Scanner(System.in);
			bot = auto;
			alive = true;
			myDiety = null;
			health = rand.nextInt(51) + 50;
			power = rand.nextInt(51) + 50;
			if(bot) {
				name = "The Bot";
			}
			else {
				name = setName();
			}
		}
		
	//Methods

	private String setName() {
		System.out.println("What shall this noble paladin be named?");
		return scan.nextLine();
	}

	public Diety getMyDiety() {
		return myDiety;
	}

	public void setMyDiety() {
		if(this.power >= 20) {
			if(this.myDiety == null || this.myDiety.isBelief() == false) {
				System.out.println(this.name + " has summoned a new diety.");
				this.myDiety = new Diety(true);
				System.out.println(this.myDiety.toString());
				this.power -= 20;
			}
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth() {
		System.out.println(this.name + " has healed.");
		int amount = rand.nextInt(this.power);
		this.power -= amount;
		this.health += amount;
		if(this.health > 100) {
			this.health = 100;
		}
		System.out.println(this.name + " now has " + this.health + " health.");
	}

	public int getPower() {
		return power;
	}

	public void setPower() {
		System.out.println(this.name + " is building power.");
		this.power += rand.nextInt(101 - this.power);
		System.out.println(this.name + " now has " + this.power + " power.");
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive() {
		if(this.alive && this.health <= 0) {
			System.err.println(this.name + " has died.");
			this.alive = false;
		}
	}
	
	public String toString() {
		String output = this.name + "\n\t";
		output += "Health:" + this.health + "\n\t";
		output += "Power:" + this.power + "\n\t"; 
		if(this.myDiety != null && this.myDiety.isBelief())
			output += "Diety:" + this.myDiety + "\n\t"; 
		return output;
	}
	
	public void turn(Paladin other) {
		String choice = " ";
		if(this.bot) {
			choice = this.actions[rand.nextInt(actions.length)];
		}
		else {
			choice = getChoice();
		}
		doAction(other, choice);
	}

	private void doAction(Paladin other, String choice) {
		if(choice.contains("heal")) {
			setHealth();
		}
		else if (choice.contains("summon")) {
			setMyDiety();
		}
		else if (choice.contains("power")) {
			setPower();
		}
		else if(choice.contains("nothing")) {
			System.out.println(this.name + " has chosen to do nothing.");
		}
		else if(choice.contains("ritual sudoku")) {
			this.health = 0;
			this.setAlive();
		}
		else if(choice.contains("attack")) {
			attack(other);
		}
		else {
			System.out.println(this.name + " does not know what " + choice + " means and got hurt!");
			this.health -= rand.nextInt(6) + 5;
		}
		
	}

	private void attack(Paladin other) {
		System.out.println(this.name + " has attacked " + other.getName() + ".");
		if(rand.nextInt(3) == 1) {
			if(other.getMyDiety() == null || other.getMyDiety().isBelief() == false) {
				System.out.println("Hit");
				other.loseHealth();
			}
			else {
				System.out.println("Hit " + other.getName() + "'s diety instead.");
				for(int i = rand.nextInt(6) + 1 ; i > 0 ; i--) {
					other.getMyDiety().setFollowers();
				}
			}
		}
		other.setAlive();
	}
	
	public void loseHealth() {
		System.out.println("Ouchie");
		this.health -= rand.nextInt(26) +25;
		this.setAlive();
	}
	
	public void printActions() {
		for( int i = 0 ; i < this.actions.length ; i++) {
			System.out.println("\t#" + (i + 1) + ": " + this.actions[i]);
		}
	}

	public String getName() {
		return this.name;
	}

	private String getChoice() {
		System.out.println("What should " + this.name + " do?");
		printActions();
		return scan.nextLine().toLowerCase();
	}
}
