package OOPNotes;

import java.util.Random;

public class Pantheon {
	
	//Attributes
	private Random rand;
	private boolean belief;
	private Diety chief;
	private Diety[] dieties;
	private int might;
	
	//Constructor
	
	public Pantheon() {
		rand = new Random();
		belief = true;
		chief = new Diety();
		setDieties();
		might = rand.nextInt(51) + 50;
		
		
	}
	
	//Methods	
	private void setDieties() {
		this.dieties = new Diety[rand.nextInt(4) + 2];
		for(int i = 0 ; i < this.dieties.length ; i ++ ) {
			this.dieties[i] = new Diety(true);
		}
	}

	
	public boolean isBelief() {
		return belief;
	}

	public void setBelief() {
		if(this.belief && (this.might <= 0 || this.chief.isBelief()== false || dietiesFallen())) {
			System.err.println(this.chief.getName().toUpperCase() + "'s PANTHEON HAS FALLEN!");
			this.belief = false;
		}
	}

	private boolean dietiesFallen() {
		for( int i = 0 ; i < this.dieties.length ; i++) {
			if(this.dieties[i].isBelief()) {
				return false;
			}
		}
		return true;
	}

	public Diety getChief() {
		return chief;
	}

	public void setChief(Diety chief) {
		this.chief = chief;
	}

	public Diety[] getDieties() {
		return dieties;
	}

	public void setDieties(Diety[] dieties) {
		this.dieties = dieties;
	}

	public int getMight() {
		return might;
	}

	public void setMight() {
		this.might -= rand.nextInt(5) +1;
	}
	
	public String toString() {
		String output = this.chief.toString();
		output += "\nMight: " + this.might;
		for( int i = 0 ; i < this.dieties.length ; i++) {
			output += "\n" + this.dieties[i].toString();
			
		}
		return output;
	}

	
	public void attack( Pantheon other) {
		System.out.println(this.chief.getName() + "'s pantheon has attacked");
		setMight();
		if(rand.nextInt(3) == 1) {
			System.out.println("Hit");
			setDamage(other);
		}
		setBelief();
	}
	
	private void setDamage(Pantheon other) {
		if(rand.nextInt(5) == 1) {
			System.out.println(other.getChief().getName() + "'s pantheon was hit!");
			for( int i = 0 ; i < other.getDieties().length ; i++) {
				if(rand.nextBoolean()) {
					other.getDieties()[i].setFollowers();
					other.getDieties()[i].setTentacles();
				}
			}
		}
	}
		
}
