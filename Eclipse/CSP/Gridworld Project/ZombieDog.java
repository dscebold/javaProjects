package GridWorldB;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import GridWorldCritters.Heart;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class ZombieDog extends Critter {

	private Random rand;
	private int life, count;

	public ZombieDog() {
		super();
		setColor(Color.GRAY);
		rand = new Random();
		life = 200;
		count = 0;
	}

	@Override
	public void act() {
		if (getGrid() == null)
			return;
		ArrayList<Actor> survivor = getSurvivor();
		if (this.life > 0 && this.count == 1) {
			for (int i = 0; i < 2; i++) {
				moveToSurvivor(survivor);
			}
			ArrayList<Actor> actors = getActors();
			processActors(actors);
			this.life--;
		}
		if (this.life == 0) {
			this.removeSelfFromGrid();
		}
		this.count++;
		if (this.count >= 6) {
			this.count = 0;
		}

	}

	private ArrayList<Actor> getSurvivor() {
		ArrayList<Location> allLocs = getGrid().getOccupiedLocations(); // saved all locations with an actor
		ArrayList<Actor> people = new ArrayList<Actor>();
		for (Location loc : allLocs) { // looks at every location
			Actor temp = getGrid().get(loc); // saves the current actor
			if ((temp instanceof Survivor) && !(temp.equals(this))) {
				people.add(temp);
			}
		}
		return people;
	}

	private double saveDist(Actor a) {
		return Math.sqrt(Math.pow(a.getLocation().getCol() - this.getLocation().getCol(), 2)
				+ Math.pow(a.getLocation().getRow() - this.getLocation().getRow(), 2));
	}

	private void moveToSurvivor(ArrayList<Actor> survivor) {
		for (Location target : getGrid().getOccupiedLocations()) {
			if (getGrid().get(target) instanceof Survivor) {
				this.setDirection(getLocation().getDirectionToward(target));
			}
		}
		Location next = getLocation().getAdjacentLocation(getDirection());
		if (getGrid().isValid(next) && getGrid().get(next) == null) { // real loc and not occupied
			makeMove(next);
		}

	}

	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			Location newZombie = a.getLocation();
			if (!(a instanceof Rock) && !(a instanceof Flower) && !(a instanceof Zombie) && !(a instanceof Survivor)
					&& !(a instanceof Bullet) && !(a instanceof Heart) && !(a instanceof ZombieDog)) {
				a.removeSelfFromGrid();
				new Zombie().putSelfInGrid(getGrid(), newZombie);
			} else if (a instanceof Survivor) {
				((Survivor) a).setLife();
			}
		}
	}

}
