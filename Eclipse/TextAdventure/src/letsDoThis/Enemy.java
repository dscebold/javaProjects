package letsDoThis;

import java.util.Random;

public class Enemy {

	// Attributes

	private int health, hit, damage, armor;
	private Random rand;
	private boolean alive;
	private String type;

	// Constructor

	public Enemy() {
		rand = new Random();
		setType();
 		alive = true; 
	}

	// Methods

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	

	private void setType() {

		int bee = rand.nextInt(10000);

		if (bee == 9999) {
			this.type = "die";
			setStats(1000000,1000000,1000000,1); 

		}
		else if (bee >= 7500 && bee < 9999) {
			this.type = "trenchcoat";
			setStats(15, 4, 6, 12);

		} else if (bee >= 5000 && bee <= 7499) {
			this.type = "zombie";
			setStats(22,3,7,8);

		} else if (bee >= 2500 && bee <= 4999) {
			this.type = "nonNewtonian";
			setStats(50, 6, 12, 13);

		} else if (bee >= 0 && bee <= 2499) {
			this.type = "skeleton";
			setStats(13,4,8,13);

		}
		
		
		
	}
	
	
	private void setStats(int heart, int punch, int ouch, int safe) {
		this.health = heart;
		this.hit = punch; 
		this.damage = ouch;
		this.armor = safe;
	}
	
	public boolean checkAlive() {
		if(this.health <= 0) {
			this.alive = false; 
		}
		return this.alive; 
	}

	public String getType() {
		return type;
	}

	

}
