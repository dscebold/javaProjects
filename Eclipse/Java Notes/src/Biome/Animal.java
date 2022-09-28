package Biome;

import java.util.Random;

public abstract class Animal {
	
	//Attributes
		protected boolean alive, gender;
		protected int lifeSpan, hunger;
		protected Random rand;
		public static int population = 0;
		
	//Constructor
		public Animal() {
			rand = new Random();
			this.alive = true;
			this.gender = rand.nextBoolean();
			hunger = rand.nextInt(51) + 50;
			lifeSpan = rand.nextInt(11) + 10;
		}
	
	//Methods
		
		public abstract Animal baby(Animal other);
		
		public abstract Animal life(Animal other, int food);
		
		public abstract void beEaten();
		
		public boolean isAlive() {
			return alive;
		}

		public void setAlive() {
			this.hunger -= rand.nextInt(6) + 5; 
			if(this.alive && (this.hunger <= 0 || this.lifeSpan <= 0)) {
				this.alive = false;
				population--;
			}
		}

		public int getLifeSpan() {
			return lifeSpan;
		}

		public void setLifeSpan() {
			this.lifeSpan--; 
			if(this.hunger <= 25) {
				this.lifeSpan -= rand.nextInt(3) + 1; 
			}
		}

		public int getHunger() {
			return hunger;
		}

		public void setHunger(int hunger) {
			this.hunger += hunger; 
			if(this.hunger > 100) {
				this.hunger = 100; 
			}
		}

		public boolean isGender() {
			return gender;
		}
	

}
 