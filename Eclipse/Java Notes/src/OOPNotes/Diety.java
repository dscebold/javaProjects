package OOPNotes;

import java.util.Random;
import java.util.Scanner;

public class Diety {
	
	//Attribute
		private String name;
		private int followers;
		private boolean belief;
		private Random rand;
		private Scanner scan;
		private boolean tentacles;
		private int tentacles1;
		private String[] names = {"Anime","The Teacher", "Clippy", "Stringy the Cheese God", "Hermes", "Luna", "Mercury", "Selene", "Cthulu", "Thor", "Ares", "Hulk", "Ra", "Jupiter", "Seth", "Chad", "Karen", "The Manager" }; 
		
	//Constructor
		public Diety() {
			scan = new Scanner(System.in);
			rand = new Random();
			belief = true;
			followers = rand.nextInt(6) + 5;
			name = setName();
			tentacles = setTentacles(); 
			
		}
		
		public Diety(boolean auto) {
			scan = new Scanner(System.in);
			rand = new Random();
			belief = true;
			followers = rand.nextInt(6) + 5;
			name = setNameAuto();
			tentacles = setTentacles(); 
			
		}
		
		private String setNameAuto() {
			return names[rand.nextInt(names.length)];
		}
	//Methods
		//source + generate getters/setters lets you automatically make getters and setters
		
		public boolean setTentacles() {
			int random = rand.nextInt(1);
			if( random == 0) {
				this.tentacles = true;
				this.tentacles1 = rand.nextInt(100) + 1;
			}
			else {
				this.tentacles = false;
			}
			return this.tentacles;
		}
		
		public String getName() {
			return name;
		}

		public String setName() {
			System.out.println("What should this diety be named?");
			String name = scan.nextLine();
			System.out.println("A new diety has emerged.... \nall hail " + name + ".");
			return name;
		}

		public int getFollowers() {
			return followers;
		}

		public void setFollowers() {
			System.out.println(this.name + " has lost followers.");
			this.followers -= rand.nextInt(2) + 1;
			if(this.followers <= 0) {
				setBelief();
			}
			else {
				System.out.println(this.name + " now has " + this.followers + " followers.");
			}
		}

		public boolean isBelief() {
			return belief;
		}

		public void setBelief() {
			if((this.followers <= 0 && this.belief) || this.tentacles1 <= 0 ) {
				System.err.println(this.name + " has faded into the sands of time.");
				this.belief = false;
			}
		}
		
		public String toString() {
			return this.name + "\n" + "Followers: " + this.followers +  "\nTentacles: " + this.tentacles1;
		}
		
		public void attack(Diety other) {
			System.out.println(this.name + "  has attacked " + other.getName() + "!");
			if(rand.nextBoolean()) {
				System.out.println("Hit!");
				int lostTentacles = rand.nextInt(11);
				this.tentacles1 -= lostTentacles;
				System.out.println(this.name + " has lost some tencalces \n" + this.name + " now has " + tentacles1 + " tentacles.");
				other.setFollowers();
				if(rand.nextInt(5)==1) {
					this.followers++;
					System.out.println(this.name + " has gained a follower!");
				}
			}
		}
}
