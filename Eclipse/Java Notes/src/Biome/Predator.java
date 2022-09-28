package Biome;

public class Predator extends Animal{
	
	//Attribute
	public static int predatorPopulation = 0;
	
	//Constructor
	public Predator() {
		super();
		predatorPopulation++;
	}

	@Override
	public Animal baby(Animal other) {
		if(other instanceof Predator && other.isAlive() && this.gender != other.isGender() && this.hunger > 25) {
			if(rand.nextInt(5) == 1) { // birth rate of 1 in 5
				return new Predator();
			}
		}
		return null;
	}

	@Override
	public Animal life(Animal other, int food) {
		Animal baby = baby(other);
		predate(other);
		setLifeSpan();
		setAlive();
		return baby;
	}

	private void predate(Animal other) {
		if(other instanceof Prey || this.hunger < 25 && other.isAlive()) {
			if(rand.nextInt(3) == 1) { // chance prey escapes
				setHunger(other.getHunger());
				other.setHunger(-100);
				other.beEaten();
			}
		}
		
	}

	@Override
	public void beEaten() {
		population--;
		predatorPopulation--;
		this.alive = false;
	}
	
	@Override
	public void setAlive() {
		int temp = population;
		super.setAlive();
		if(temp != population) {
			predatorPopulation--;
		}
	}

}
