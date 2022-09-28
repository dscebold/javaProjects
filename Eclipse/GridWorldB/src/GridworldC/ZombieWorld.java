package GridworldC;

import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ZombieWorld extends ActorWorld {

	private Random rand;
	private int numZombies, numZombieDogs;
	private boolean buildings;
	private int lifeCount;

	public ZombieWorld() {
		super();
		rand = new Random();
		numZombies = 0;
		numZombieDogs = 0;
		buildings = true;
		lifeCount = 3; 

	}

	public ZombieWorld(Grid grid) {
		super(grid);
		rand = new Random();
		numZombies = 0;
		numZombieDogs = 0;
		buildings = true;
		lifeCount = 3; 
	}

	@Override
	public void step() {
		setMessage("Life: " + lifeCount + "\nZombies: " + this.numZombies + "\tZombie Dogs: " + this.numZombieDogs);
		Grid<Actor> gr = getGrid();
		if(buildings == true) {
			makeBuildings();
		}
		makeZombieDogs();
		makeZombies();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for (Location loc : gr.getOccupiedLocations())
			actors.add(gr.get(loc));

		for (Actor a : actors) {
			// only act if another actor hasn't removed a
			if (a.getGrid() == gr) {
				a.act();
				if(a instanceof Survivor) {
					lifeCount = ((Survivor) a).getLife(); 
				}
			}
		}
		this.numZombieDogs = getZombieDogs();
		this.numZombies = getZombies();
	}

	public int getZombieDogs() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations();
		ArrayList<Actor> zombieDogs = new ArrayList<>();
		for (Location a : allLocs) {
			Actor temp = getGrid().get(a);
			if (temp instanceof ZombieDog) {
				zombieDogs.add(temp);
			}
		}
		return zombieDogs.size();
	}

	public int getZombies() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations();
		ArrayList<Actor> zombies = new ArrayList<>();
		for (Location a : allLocs) {
			Actor temp = getGrid().get(a);
			if (temp instanceof Zombie) {
				zombies.add(temp);
			}
		}
		return zombies.size();
	}

	public void makeZombies() {
		if (this.numZombies < 150) {
			Zombie mort = new Zombie();
			mort.putSelfInGrid(getGrid(), getRandomEmptyLocation());
		}

	}
	public void makeZombieDogs() {
		if(this.numZombieDogs < 50) {
			ZombieDog maurice = new ZombieDog();
			maurice.putSelfInGrid(getGrid(), getRandomEmptyLocation());
		}
	}
	
	public void makeBuildings() {
		for( int i = 0 ; i < 50 ; i++) {
			Building bob = new Building();
			bob.putSelfInGrid(getGrid(), getRandomEmptyLocation());
			bob.act(); 
		}
		buildings = false;
	}

}
