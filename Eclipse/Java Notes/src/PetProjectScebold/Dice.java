package PetProjectScebold;

import java.util.Random;

public class Dice {
	
	//Attributes
		private Random rand;
		private double chance;
	
	//Constructor
		public Dice() {
			rand = new Random();
			chance = 1.0;
		}
	
	//Methods
		public boolean roll() {
			int val = rand.nextInt(6) + 1; // random number between 1-6
			if(this.chance >= val) { // probability that the pet does the trick
				if(this.chance < 6) { // if the trick is not 100% learned
					this.chance++; // get closer to 100%
				}
				return true; // yes do the trick
			}
			return false; // do not do the trick
		}
		
		public String getProb() {
			int num = (int) ((this.chance/ 6.0)*100); // (int) 33.33333333 = 33
			return num + "%";
		}
}
