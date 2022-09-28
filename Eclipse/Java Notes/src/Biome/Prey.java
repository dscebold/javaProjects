package Biome;

public class Prey extends Animal{
	
	//Attribute
	public static int preyPopulation = 0;
	
	//Constructor
	public Prey() {
		super();
		preyPopulation++;
	}
	
	public Prey(int hunger) {
		super();
		preyPopulation++;
		this.hunger = rand.nextInt(hunger);
	}

	@Override
	public Animal baby(Animal other) {
		if(other instanceof Prey && other.isAlive() && this.gender != other.isGender() && this.hunger > 25) {
			if(rand.nextInt(3) == 1) { // birth rate of 1 in 2
				return new Prey();
			}
		}
		return null;
	}

	@Override
	public Animal life(Animal other, int food) {
		Animal baby = baby(other);
		setHunger(food);
		setLifeSpan();
		setAlive();
		return baby;
	}


	@Override
	public void beEaten() {
		population--;
		preyPopulation--;
		this.alive = false;
	}
	
	@Override
	public void setAlive() {
		int temp = population;
		super.setAlive();
		if(temp != population) {
			preyPopulation--;
		}
	}

}
