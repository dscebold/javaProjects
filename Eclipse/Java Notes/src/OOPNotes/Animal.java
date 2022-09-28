package OOPNotes;

import java.util.Random;

public class Animal {

	// Attributes

	private boolean infected, alive, gender;
	private int health;
	private Random rand;
	public static int population = 0; // belong to a class not an instance
	public static int infectedPopulation = 0;

	// Constructor
	public Animal(boolean isInfected) {
		rand = new Random();
		this.infected = isInfected;
		this.alive = true;
		this.gender = rand.nextBoolean();
		this.health = rand.nextInt(26) + 25;
		population++;
		if (this.infected) {
			infectedPopulation++;
		}
	}

	// Methods

	public boolean isInfected() {
		return infected;
	}

	public void setInfected() {
		if (this.alive && this.infected == false) {
			this.infected = true;
			infectedPopulation++;
		}
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive() {
		if (this.alive && this.health <= 0) {
			this.alive = false;
			population--;
			if (this.infected) {
				infectedPopulation--;
			}
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth() {
		this.health -= rand.nextInt(2) + 1; // normal age
		if (this.infected) {
			this.health -= rand.nextInt(7) + 3; // Lethality
			if (rand.nextInt(4) == 1) { // chance of recovery
				this.infected = false;
				infectedPopulation--;
			}
		}
		setAlive();
	}

	public boolean isGender() {
		return gender;
	}

	public Animal animalLife(Animal other) {
		infect(other);
		setHealth();
		return baby(other);
	}

	private Animal baby(Animal other) {
		Animal baby = null;
		if (this.gender != other.isGender() && rand.nextInt(4) == 1) { // birth rate 1/3
			baby = new Animal(this.infected || other.infected);
			// baby will be infected if either parent is infected
		}
		return baby;
	}

	private void infect(Animal other) {
		if (this.infected != other.isInfected() && rand.nextBoolean()) { // infectivity
			this.setInfected();
			other.setInfected();
		}

	}

}
